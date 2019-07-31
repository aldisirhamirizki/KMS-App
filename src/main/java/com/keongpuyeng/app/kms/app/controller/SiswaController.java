/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keongpuyeng.app.kms.app.controller;

import com.google.gson.Gson;
import com.keongpuyeng.app.kms.app.model.EnumJenisKelamin;
import com.keongpuyeng.app.kms.app.model.Bank;
import com.keongpuyeng.app.kms.app.model.KonfirmasiPembayaran;
import com.keongpuyeng.app.kms.app.model.Level;
import com.keongpuyeng.app.kms.app.model.Kursus;
import com.keongpuyeng.app.kms.app.model.Pendaftaran;
import com.keongpuyeng.app.kms.app.model.Program;
import com.keongpuyeng.app.kms.app.model.SessionModel;
import com.keongpuyeng.app.kms.app.service.ISiswaService;
import com.keongpuyeng.app.kms.app.model.Siswa;
import com.keongpuyeng.app.kms.app.model.SiswaDto;
import com.keongpuyeng.app.kms.app.param.Param;
import com.keongpuyeng.app.kms.app.service.IBankService;
import com.keongpuyeng.app.kms.app.service.IGenerateReport;
import com.keongpuyeng.app.kms.app.service.IKonfirmasiService;
import com.keongpuyeng.app.kms.app.service.IKursusService;
import com.keongpuyeng.app.kms.app.service.ILevelService;
import com.keongpuyeng.app.kms.app.service.IMailService;
import com.keongpuyeng.app.kms.app.service.IPendaftaranService;
import com.keongpuyeng.app.kms.app.service.IProgramService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.apache.tika.Tika;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 *
 * @author Aldis-PC
 */
@Controller
@RequestMapping("/siswa")
public class SiswaController {

    private static final Logger LOG = Logger.getLogger(SiswaController.class);

    @Autowired
    private ISiswaService siswaService;

    @Autowired
    private IProgramService progService;

    @Autowired
    private IKursusService kursusService;

    @Autowired
    private ILevelService levelService;

    @Autowired
    private IBankService bankService;

    @Autowired
    private IPendaftaranService pendService;

    @Autowired
    private IKonfirmasiService konfirmasiService;

    @Autowired
    private IMailService mailService;
    
    @Autowired
    private IGenerateReport report;

    @GetMapping("/list_siswa")
    public String listSiswa(Model theModel) {
        List<Siswa> listSiswa = siswaService.getListSiswa();
        List<KonfirmasiPembayaran> listKonfirm = konfirmasiService.getListKonfirmasi();
        List<SiswaDto> listDto = new ArrayList<>();

        for (Siswa siswa : listSiswa) {
            SiswaDto siswaDto = new SiswaDto();

            siswaDto.setIdSiswa(siswa.getIdSiswa());
            siswaDto.setIdDaftar(siswa.getIdDaftar().getIdDaftar());
            siswaDto.setNamaDaftar(siswa.getIdDaftar().getNamaDaftar());
            siswaDto.setTanggalLahir(siswa.getTanggalLahir());
            siswaDto.setJenisKelamin(siswa.getJenisKelamin().name());
            siswaDto.setTempatTinggal(siswa.getTempatTinggal());
            siswaDto.setTelepon(siswa.getTelepon());
            siswaDto.setIdProgram(siswa.getIdProgram().getNamaProgram());
            siswaDto.setIdKursus(siswa.getIdKursus().getNamaKursus());
            siswaDto.setIdLevel(siswa.getIdLevel().getNamaLevel());
            siswaDto.setIdBank(siswa.getIdBank().getNamaBank());
            String statusPembayaran = listKonfirm.stream()
                    .filter(p -> p.getIdSiswa().equalsIgnoreCase(siswa.getIdSiswa()))
                    .map(x -> x.getStatus())
                    .collect(Collectors.joining());
            siswaDto.setStatus(statusPembayaran);
            // list dto
            listDto.add(siswaDto);

        }
        theModel.addAttribute("siswa", listDto);
        return "list_siswa"; // belum ada jsp
    }

    @GetMapping("/search")
    public String search(Model theModel, @RequestParam("cariSiswa") String cari) {
        System.out.println("CARI:" + cari);
        List<SiswaDto> listSearch = siswaService.getSearch(cari);
        theModel.addAttribute("siswa", listSearch);
        return "list_siswa";
    }

    @GetMapping("/profil")
    //    @Transactional
    public String showFormForAdd(Model theModel, HttpServletRequest req, HttpServletResponse response) {

        LOG.debug("inside show siswa-form handler method");
        SessionModel sessionModel2 = (SessionModel) req.getSession().getAttribute("sessionModel");
        LOG.debug("PRINT SESSION MODEL @: " + new Gson().toJson(sessionModel2));
        // CHECK SISWA PUNYA ID DAFTAR ATAU BELUM
        String idDaftar = sessionModel2.getIdDaftar();
        Siswa siswa = siswaService.getSiswaByIdDaftar(idDaftar);
        String displayImage = "";
        SiswaDto siswaDto = new SiswaDto();
        if (siswa == null) {
            Pendaftaran pendaftaran = pendService.getPendaftaran(idDaftar);

            siswaDto.setIdDaftar(pendaftaran.getIdDaftar());
            siswaDto.setNamaDaftar(pendaftaran.getNamaDaftar());
            siswaDto.setEmailDaftar(pendaftaran.getEmailDaftar());

            theModel.addAttribute("pendaftaran", pendaftaran);
        } else {

            KonfirmasiPembayaran konfirmasiPembayaran = konfirmasiService.getKonfirmasiByIdSiswa(siswa.getIdSiswa());

            siswaDto.setIdSiswa(siswa.getIdSiswa());
            siswaDto.setIdDaftar(siswa.getIdDaftar().getIdDaftar());
            siswaDto.setNamaDaftar(siswa.getIdDaftar().getNamaDaftar());
            siswaDto.setEmailDaftar(siswa.getIdDaftar().getEmailDaftar());

            siswaDto.setImage(siswa.getImage());

            siswaDto.setTelepon(siswa.getTelepon());
            siswaDto.setJenisKelamin(siswa.getJenisKelamin().name());
            siswaDto.setTanggalLahir(siswa.getTanggalLahir());
            siswaDto.setTempatTinggal(siswa.getTempatTinggal());
            siswaDto.setIdProgram(siswa.getIdProgram().getIdProgram());
            siswaDto.setIdKursus(siswa.getIdKursus().getIdKursus());
            siswaDto.setIdLevel(siswa.getIdLevel().getIdLevel());
            siswaDto.setIdBank(siswa.getIdBank().getIdBank());
            siswaDto.setTotalBiaya(konfirmasiPembayaran.getTotalBiaya());
            siswaDto.setIdKonfirmasi(konfirmasiPembayaran.getIdKonfirmasi());

            Tika tika = new Tika();
            if (siswa.getImage() != null) {
            String contentType = tika.detect(siswa.getImage());
            String encodedImage = Base64.encodeBase64String(siswa.getImage());
            displayImage = Param.IMG_SRC_PREFIX + contentType + Param.IMG_SRC_SUFIX + encodedImage;
                System.out.println("DISPLAY IMAGE:" + displayImage);
            }
        }

        List<EnumJenisKelamin> jenisKelamin = Arrays.asList(EnumJenisKelamin.values());

        List<Program> listProgram = progService.getListPrograms();
        Map<String, String> mapProgram = new HashMap<>();
        listProgram.stream().forEach(p -> {
            mapProgram.put(p.getIdProgram(), p.getNamaProgram());
        });

        List<Kursus> listKursus = kursusService.getListKursus();
        Map<String, String> mapKursus = new HashMap<>();
        listKursus.stream().forEach(p -> {
            mapKursus.put(p.getIdKursus(), p.getNamaKursus());
        });

        List<Level> listLevel = levelService.getListLevel();
        Map<String, String> mapLevel = new HashMap<>();
        listLevel.stream().forEach(p -> {
            mapLevel.put(p.getIdLevel(), p.getNamaLevel());
        });

        // bank disini
        List<Bank> listBank = bankService.getListBank();
        Map<String, String> mapBank = new HashMap<>();
        listBank.stream().forEach(p -> {
            mapBank.put(p.getIdBank(), p.getNamaBank());
        });

        theModel.addAttribute("imageDisplay", displayImage);

        theModel.addAttribute("jenisKelamin", jenisKelamin);
        theModel.addAttribute("program", listProgram);
        theModel.addAttribute("kursus", listKursus);
        theModel.addAttribute("level", listLevel);
        theModel.addAttribute("bank", listBank);
        theModel.addAttribute("siswa", siswaDto);
//        theModel.addAttribute("imageUpload", imageUpload);

        return "profil";
    }

//    @GetMapping("/imageDisplay")
//    public void showImage(HttpServletRequest req, HttpServletResponse response) throws IOException {
//        SessionModel sessionModel2 = (SessionModel) req.getSession().getAttribute("sessionModel");
//        String idDaftar = sessionModel2.getIdDaftar();
//        Siswa siswa2 = siswaService.getSiswaByIdDaftar(idDaftar);
//
//        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
//        response.getOutputStream().write(siswa2.getImage());
//
//        response.getOutputStream().close();
//    }
    @PostMapping("/saveSiswa")
    @Transactional
    public String saveSiswa(@ModelAttribute("siswa") @Valid SiswaDto siswaDto,
            BindingResult bindingResult,
            HttpServletRequest req,
            @RequestParam CommonsMultipartFile imageUpload) {
        

        System.out.println("IMAGE UPLOAD: " + imageUpload.getName());
        System.out.println("IMAGE UPLOAD: " + imageUpload.getBytes());
        System.out.println("IMAGE UPLOAD: " + imageUpload.getContentType());
        System.out.println("IMAGE UPLOAD: " + imageUpload.getOriginalFilename());
        System.out.println("IMAGE UPLOAD: " + imageUpload.getStorageDescription());
        System.out.println("IMAGE UPLOAD: " + imageUpload.toString());

        String json = new Gson().toJson(siswaDto);
        System.out.println("This is SISWA: " + json);

        Pendaftaran pendaftaran = pendService.getPendaftaran(siswaDto.getIdDaftar());
        pendaftaran.setNamaDaftar(siswaDto.getNamaDaftar());
        pendaftaran.setEmailDaftar(siswaDto.getEmailDaftar());
        Program program = progService.getProgram(siswaDto.getIdProgram());
        Kursus kursus = kursusService.getKursus(siswaDto.getIdKursus());
        Level level = levelService.getLevel(siswaDto.getIdLevel());
        Bank bank = bankService.getBank(siswaDto.getIdBank());
//        System.out.println("BANKOK BANK: " + bank.toString());

        Siswa siswa = new Siswa();

        if (imageUpload.isEmpty()) {
            siswa.setImage(siswaService.getImageSiswa(siswaDto.getIdSiswa()));
        } else {
            siswa.setImage(imageUpload.getBytes());
        }
        siswa.setJenisKelamin(EnumJenisKelamin.valueOf(siswaDto.getJenisKelamin()));
        siswa.setTanggalLahir(siswaDto.getTanggalLahir());
        siswa.setTempatTinggal(siswaDto.getTempatTinggal());
        siswa.setTelepon(siswaDto.getTelepon());
        siswa.setIdDaftar(pendaftaran);
        siswa.setIdProgram(program);
        siswa.setIdKursus(kursus);
        siswa.setIdLevel(level);
        siswa.setIdBank(bank);
        System.out.println("INI SISWA: " + siswa.toString());
        KonfirmasiPembayaran kp;
        if (siswaDto.getIdSiswa() == null || siswaDto.getIdSiswa().isEmpty()) {
            System.out.println("SISWA DTO: " + new Gson().toJson(siswaDto));
            System.out.println("SISWA IS NULL");
            siswa = siswaService.saveSiswa(siswa);
            pendService.updatePendaftaran(pendaftaran);

            KonfirmasiPembayaran konfirmasiPembayaran = new KonfirmasiPembayaran();
            konfirmasiPembayaran.setIdSiswa(siswa.getIdSiswa());
            konfirmasiPembayaran.setTglKonfirmasi(new Date());
            konfirmasiPembayaran.setTotalBiaya(siswaDto.getTotalBiaya());
            konfirmasiPembayaran.setBank(bank);
            konfirmasiPembayaran.setStatus(Param.BELUM_BAYAR);
//            konfirmasiPembayaran.setImageBukti("TES IMAGE");
            konfirmasiService.saveKonfirmasi(konfirmasiPembayaran);
            kp = konfirmasiPembayaran;

            SessionModel sessionModel = new SessionModel();
            sessionModel.setIdDaftar(siswaDto.getIdDaftar());
            sessionModel.setNamaDaftar(siswaDto.getNamaDaftar());
            sessionModel.setEmailDaftar(siswaDto.getEmailDaftar());
            req.getSession().setAttribute("sessionModel", sessionModel);
        } else {
            System.out.println("SISWA DTO: " + new Gson().toJson(siswaDto));
            System.out.println("SISWA IS EXIST");
            System.out.println("BANK: " + bank.toString());
            siswa.setIdSiswa(siswaDto.getIdSiswa());
            siswaService.updateSiswa(siswa);
            pendService.updatePendaftaran(pendaftaran);

            KonfirmasiPembayaran konfirmasiPembayaran = konfirmasiService.getKonfirmasiByIdSiswa(siswaDto.getIdSiswa());
            if (konfirmasiPembayaran == null) {
                konfirmasiPembayaran = new KonfirmasiPembayaran();
                konfirmasiPembayaran.setIdSiswa(siswaDto.getIdSiswa());
                konfirmasiPembayaran.setTglKonfirmasi(new Date());
                konfirmasiPembayaran.setTotalBiaya(siswaDto.getTotalBiaya());
                konfirmasiPembayaran.setBank(bank);
                konfirmasiPembayaran.setStatus(Param.BELUM_BAYAR);
//                konfirmasiPembayaran.setImageBukti("TES IMAGE");
                konfirmasiService.saveKonfirmasi(konfirmasiPembayaran);
            } else {
                konfirmasiPembayaran.setIdSiswa(siswaDto.getIdSiswa());
                konfirmasiPembayaran.setTglKonfirmasi(new Date());
                konfirmasiPembayaran.setTotalBiaya(siswaDto.getTotalBiaya());
                konfirmasiPembayaran.setBank(bank);
                konfirmasiService.updateKonfirmasi(konfirmasiPembayaran);
            }
            kp = konfirmasiPembayaran;

            SessionModel sessionModel = new SessionModel();
            sessionModel.setIdDaftar(siswaDto.getIdDaftar());
            sessionModel.setNamaDaftar(siswaDto.getNamaDaftar());
            sessionModel.setEmailDaftar(siswaDto.getEmailDaftar());
            req.getSession().setAttribute("sessionModel", sessionModel);
        }

        // send email with new thread
        final SiswaDto sendSiswa = siswaDto;
        final Program sendProgram = program;
        final Kursus sendKursus = kursus;
        final Level sendLevel = level;
        final Bank sendBank = bank;
        final KonfirmasiPembayaran sendKp = kp;
        final String emailAddress = siswaDto.getEmailDaftar();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("START RUN NEW THREAD -> SEND EMAIL");
                System.out.println("SISWA DTO NEW THREAD -> " + new Gson().toJson(sendSiswa));
                HashMap<String, Object> model = new HashMap<>();
                model.put("siswa", sendSiswa);
                model.put("program", sendProgram);
                model.put("kursus", sendKursus);
                model.put("level", sendLevel);
                model.put("bank", sendBank);
                model.put("konfirmasi", sendKp);
                mailService.sendMail(model, emailAddress);
            }
        });
        thread.start();

        System.out.println("OKE DEHHHH");
        return "redirect:/siswa/profil";
    }

    @GetMapping("updateSiswa")
    public String showFormForUpdate(@RequestParam("idSiswa") String theId,
            Model theModel) {
        Siswa siswas = siswaService.getSiswa(theId);
        theModel.addAttribute("siswa", siswas);
        return "form_siswa";
    }

    @GetMapping("/delete")
    public String deleteProg(@RequestParam("idSiswa") String theId) {
        siswaService.deleteSiswa(theId);
        return "redirect:/siswa/list_siswa";
    }
    
    @GetMapping(value = "/getPdf", produces = MediaType.APPLICATION_PDF_VALUE)
    @Transactional
    public @ResponseBody byte[] downloadReport(@RequestParam("cariReport") String cariReport){
        byte[] pdf = report.generatePdfReportSiswa(cariReport);        
        return pdf;
    }
}
