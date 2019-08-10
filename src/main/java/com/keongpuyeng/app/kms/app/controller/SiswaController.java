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

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

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
    public String listSiswaPagination(Model theModel,
                                      @RequestParam(value = "cariSiswa", defaultValue = "") String cari,
                                      @RequestParam(value = "page", defaultValue = "0") int currentPage) {
        Pageable page = PageRequest.of(currentPage, 5);
        Page<Object> objectPage = siswaService.getSiswaPagination(cari, page);
        List<SiswaDto> dtoList = new ArrayList<>();
        for (Object object : objectPage) {
            Object[] obj = (Object[]) object;
            SiswaDto dto = new SiswaDto();
            
            dto.setIdSiswa(obj[0].toString());
            dto.setNamaDaftar(obj[1].toString());
            dto.setJenisKelamin(obj[2].toString());
            try {
                dto.setTanggalLahir(sdf.parse(obj[3].toString()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            dto.setTempatTinggal(obj[4].toString());
            dto.setTelepon(obj[5].toString());
            dto.setIdProgram(obj[6].toString());
            dto.setIdKursus(obj[7].toString());
            dto.setIdLevel(obj[8].toString());
            dto.setStatus(obj[9] == null ? "" : obj[9].toString());

            dtoList.add(dto);
        }

        theModel.addAttribute("cari", cari);
        theModel.addAttribute("siswa", dtoList);
        theModel.addAttribute("page", objectPage);

        LOG.info("objectPage TOTAL ELEMENTS: " + objectPage.getTotalElements());
        LOG.info("objectPage TOTAL PAGES: " + objectPage.getTotalPages());
        LOG.info("objectPage NUMBER (HALAMAN SAAT INI): " + objectPage.getNumber());
        LOG.info("objectPage NUMBER OF ELEMENTS (JUMLAH ELEMENT DI HALAMAN): " + objectPage.getNumberOfElements());
        LOG.info("objectPage CONTENT SIZE: " + objectPage.getContent().size());
        LOG.info("objectPage IS FIRST: " + objectPage.isFirst());
        LOG.info("objectPage IS LAST: " + objectPage.isLast());
        LOG.info("objectPage HAS CONTENT: " + objectPage.hasContent());
        LOG.info("objectPage HAS NEXT: " + objectPage.hasNext());
        LOG.info("objectPage HAS PREVIOUS: " + objectPage.hasPrevious());
        
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

            if (siswa.getImage() != null) {
                displayImage = getImageBase64(siswa.getImage());
            }
        }

        List<EnumJenisKelamin> jenisKelamin = Arrays.asList(EnumJenisKelamin.values());
        List<Program> listProgram = progService.getListPrograms();
        List<Kursus> listKursus = kursusService.getListKursus();
        List<Level> listLevel = levelService.getListLevel();
        List<Bank> listBank = bankService.getListBank();

        theModel.addAttribute("imageDisplay", displayImage);
        theModel.addAttribute("jenisKelamin", jenisKelamin);
        theModel.addAttribute("program", listProgram);
        theModel.addAttribute("kursus", listKursus);
        theModel.addAttribute("level", listLevel);
        theModel.addAttribute("bank", listBank);
        theModel.addAttribute("siswa", siswaDto);

        return "profil";
    }

    @PostMapping("/saveSiswa")
    @Transactional
    public String saveSiswa(@ModelAttribute("siswa") @Valid SiswaDto siswaDto,
            BindingResult bindingResult,
            HttpServletRequest req,
            @RequestParam CommonsMultipartFile imageUpload,
            @RequestParam String hiddenImage, Model model) {

        String json = new Gson().toJson(siswaDto);
        LOG.debug("This is SiswaDto: " + json);

        bindingResult.getFieldErrors().stream().forEach(p -> {
            LOG.debug("Field: " + p.getField());
            LOG.debug("RejectedValue: " + (p.getRejectedValue() != null ? p.getRejectedValue().toString() : "ERROR NULL INI"));
            LOG.debug("BindingFailure: " + p.isBindingFailure());
            LOG.debug("Field: " + p.getField());
            LOG.debug("Code: " + p.getCode() );
            LOG.debug("DefaultMessage: " + p.getDefaultMessage());
            LOG.debug("ObjectName: " + p.getObjectName());
            LOG.debug("ToString: " + p.toString());
            LOG.debug("----------------------");
        });
        
        LOG.debug("IMAGE UPLOAD: " + imageUpload.isEmpty());
        LOG.debug("IMAGE UPLOAD: " + imageUpload.getName());
        LOG.debug("IMAGE UPLOAD: " + imageUpload.getBytes());
        LOG.debug("IMAGE UPLOAD: " + imageUpload.getContentType());
        LOG.debug("IMAGE UPLOAD: " + imageUpload.getOriginalFilename());
        LOG.debug("IMAGE UPLOAD: " + imageUpload.getStorageDescription());
        LOG.debug("IMAGE UPLOAD: " + imageUpload.toString());
        LOG.debug("HIDDEN IMAGE: " + hiddenImage);

        if(bindingResult.hasErrors()){
            String displayImage;
            if(!imageUpload.isEmpty()){
                displayImage = getImageBase64(imageUpload.getBytes());
            }else {
                 displayImage = hiddenImage;
            }

            List<EnumJenisKelamin> jenisKelamin = Arrays.asList(EnumJenisKelamin.values());
            List<Program> listProgram = progService.getListPrograms();
            List<Kursus> listKursus = kursusService.getListKursus();
            List<Level> listLevel = levelService.getListLevel();
            List<Bank> listBank = bankService.getListBank();
            model.addAttribute("imageDisplay", displayImage);
            model.addAttribute("jenisKelamin", jenisKelamin);
            model.addAttribute("program", listProgram);
            model.addAttribute("kursus", listKursus);
            model.addAttribute("level", listLevel);
            model.addAttribute("bank", listBank);
            return "profil";
        }

        Pendaftaran pendaftaran = pendService.getPendaftaran(siswaDto.getIdDaftar());
        pendaftaran.setNamaDaftar(siswaDto.getNamaDaftar());
        pendaftaran.setEmailDaftar(siswaDto.getEmailDaftar());
        Program program = progService.getProgram(siswaDto.getIdProgram());
        Kursus kursus = kursusService.getKursus(siswaDto.getIdKursus());
        Level level = levelService.getLevel(siswaDto.getIdLevel());
        Bank bank = bankService.getBank(siswaDto.getIdBank());

        Siswa siswa = new Siswa();

        if (imageUpload.isEmpty()) {
            if(!hiddenImage.isEmpty()){
                String[] splitHiddenImg = hiddenImage.split(",");
                byte[] base64Image = Base64.decodeBase64(splitHiddenImg[1]);
                siswa.setImage(base64Image);
            }else{
                siswa.setImage(siswaService.getImageSiswa(siswaDto.getIdSiswa()));
            }
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
        KonfirmasiPembayaran kp;
        if (siswaDto.getIdSiswa() == null || siswaDto.getIdSiswa().isEmpty()) {
            siswa = siswaService.saveSiswa(siswa);
            pendService.updatePendaftaran(pendaftaran);

            KonfirmasiPembayaran konfirmasiPembayaran = new KonfirmasiPembayaran();
            konfirmasiPembayaran.setIdSiswa(siswa.getIdSiswa());
            konfirmasiPembayaran.setTglKonfirmasi(new Date());
            konfirmasiPembayaran.setTotalBiaya(siswaDto.getTotalBiaya());
            konfirmasiPembayaran.setBank(bank);
            konfirmasiPembayaran.setStatus(Param.BELUM_BAYAR);
            konfirmasiService.saveKonfirmasi(konfirmasiPembayaran);
            kp = konfirmasiPembayaran;

            SessionModel sessionModel = new SessionModel();
            sessionModel.setIdDaftar(siswaDto.getIdDaftar());
            sessionModel.setNamaDaftar(siswaDto.getNamaDaftar());
            sessionModel.setEmailDaftar(siswaDto.getEmailDaftar());
            req.getSession().setAttribute("sessionModel", sessionModel);
        } else {
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

        return "redirect:/siswa/profil";
    }

    @GetMapping("updateSiswa")
    public String showFormForUpdate(@RequestParam("idSiswa") String theId,
            Model theModel) {
        Siswa siswa = siswaService.getSiswa(theId);
        KonfirmasiPembayaran konfirmasiPembayaran = konfirmasiService.getKonfirmasiByIdSiswa(siswa.getIdSiswa());
        SiswaDto siswaDto = new SiswaDto();
        String displayImage = "";

        siswaDto.setIdSiswa(siswa.getIdSiswa());
        siswaDto.setIdDaftar(siswa.getIdDaftar().getIdDaftar());
        siswaDto.setNamaDaftar(siswa.getIdDaftar().getNamaDaftar());
        siswaDto.setEmailDaftar(siswa.getIdDaftar().getEmailDaftar());
        siswaDto.setImage(siswa.getImage());
        siswaDto.setTelepon(siswa.getTelepon());
        siswaDto.setJenisKelamin(siswa.getJenisKelamin().name());
        siswaDto.setTanggalLahir(siswa.getTanggalLahir());
        siswaDto.setTempatTinggal(siswa.getTempatTinggal());
        siswaDto.setNamaProgram(siswa.getIdProgram().getNamaProgram());
        siswaDto.setNamaKursus(siswa.getIdKursus().getNamaKursus());
        siswaDto.setNamaLevel(siswa.getIdLevel().getNamaLevel());
        siswaDto.setNamaBank(siswa.getIdBank().getIdBank());
        siswaDto.setTotalBiaya(konfirmasiPembayaran.getTotalBiaya());
        siswaDto.setIdKonfirmasi(konfirmasiPembayaran.getIdKonfirmasi());

        Tika tika = new Tika();
        if (siswa.getImage() != null) {
            String contentType = tika.detect(siswa.getImage());
            String encodedImage = Base64.encodeBase64String(siswa.getImage());
            displayImage = Param.IMG_SRC_PREFIX + contentType + Param.IMG_SRC_SUFIX + encodedImage;
            LOG.debug("DISPLAY IMAGE:" + displayImage);
        }

        theModel.addAttribute("imageDisplay", displayImage);
        theModel.addAttribute("siswa", siswaDto);
        return "form_siswa";
    }

    @GetMapping("/delete")
    public String deleteProg(@RequestParam("idSiswa") String theId) {
        siswaService.deleteSiswa(theId);
        return "redirect:/siswa/list_siswa";
    }

    @GetMapping(value = "/getPdf", produces = MediaType.APPLICATION_PDF_VALUE)
    @Transactional
    public @ResponseBody
    byte[] downloadReport(@RequestParam("cariReport") String cariReport) {
        byte[] pdf = report.generatePdfReportSiswa(cariReport);
        return pdf;
    }

    private String getImageBase64(byte[] image){
        Tika tika = new Tika();
        String contentType = tika.detect(image);
        String encodedImage = Base64.encodeBase64String(image);
        String imageBase64 = Param.IMG_SRC_PREFIX + contentType + Param.IMG_SRC_SUFIX + encodedImage;
        return imageBase64;
    }

    /*@GetMapping("/list_siswa_BOOM")
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
            listDto.add(siswaDto);
        }
        theModel.addAttribute("siswa", listDto);
        return "list_siswa";
    }*/

    /*@GetMapping("/search")
    public String search(Model theModel, @RequestParam("cariSiswa") String cari) {
        LOG.debug("CARI:" + cari);
        List<SiswaDto> listSearch = siswaService.getSearch(cari);
        theModel.addAttribute("siswa", listSearch);
        theModel.addAttribute("cari", cari);
        return "list_siswa";
    }*/
}
