/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keongpuyeng.app.kms.app.controller;

import com.google.gson.Gson;
import com.keongpuyeng.app.kms.app.model.ErrorMessage;
import com.keongpuyeng.app.kms.app.model.KonfirmasiDto;
import com.keongpuyeng.app.kms.app.model.KonfirmasiPembayaran;
import com.keongpuyeng.app.kms.app.model.ValidationResponse;
import com.keongpuyeng.app.kms.app.param.Param;
import com.keongpuyeng.app.kms.app.service.IGenerateReport;
import com.keongpuyeng.app.kms.app.service.IKonfirmasiService;
import com.keongpuyeng.app.kms.app.service.ISiswaService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/konfirmasi")
public class KonfirmasiController {

    private static final Logger LOG = Logger.getLogger(KonfirmasiController.class);

    @Autowired
    private IKonfirmasiService konfirmService;

    @Autowired
    private ISiswaService siswaService;
    
    @Autowired
    private IGenerateReport report;

    @GetMapping("/list_konfirmasi")
    public String listKonfirmasi(Model theModel) {
        List<KonfirmasiDto> listKonfirmNama = konfirmService.getListKonfirmasiNama();
        theModel.addAttribute("konfirm", listKonfirmNama);
        return "list_konfirmasi";
    }

    // /KMS-App/konfirmasi/form_konfirmasi/S-0005
    @GetMapping("/form_konfirmasi/{idSiswa}")
    public String konfirmForm(@PathVariable("idSiswa") String idSiswa, Model theModel) {
        System.out.println("KONFIRMASI ID SISWA: " + idSiswa);
        KonfirmasiDto konfirmasiDto = konfirmService.getKonfirmasiForm(idSiswa);
        
        
        
        Tika tika = new Tika();
        String displayImage = "";
        if (konfirmasiDto.getDisplayImageBukti() != null) {
            String contentType = tika.detect(konfirmasiDto.getDisplayImageBukti());
            String encodedImage = Base64.encodeBase64String(konfirmasiDto.getDisplayImageBukti());
            displayImage = Param.IMG_SRC_PREFIX + contentType + Param.IMG_SRC_SUFIX + encodedImage;

            System.out.println("DISPLAY IMAGE:" + displayImage);

        }

        theModel.addAttribute("imageDisplay", displayImage);

        theModel.addAttribute("konfirmasiPembayaran", konfirmasiDto);
        return "form_konfirmasi";
    }

    @PostMapping("/saveKonfirmasi")
    public String saveKonfirmasi(@ModelAttribute("konfirmasiPembayaran") @Valid KonfirmasiDto konfirmasiDto,
            BindingResult bindingResult, Model model) {

        System.out.println("KONFIRMASI DTO: " + new Gson().toJson(konfirmasiDto));

        
        
        KonfirmasiPembayaran konfirmasiPembayaran = new KonfirmasiPembayaran();
        konfirmasiPembayaran = konfirmService.getKonfirmasi(konfirmasiDto.getIdKonfirmasi());

        if (!konfirmasiDto.getImageBukti().isEmpty()) {
            CommonsMultipartFile cms = (CommonsMultipartFile) konfirmasiDto.getImageBukti();
            konfirmasiPembayaran.setImageBukti(cms.getBytes());
        }

        konfirmasiPembayaran.setTglKonfirmasi(new Date());
        konfirmasiPembayaran.setStatus(Param.SUDAH_BAYAR);
        System.out.println("KONFIRMASI PEMBAYARAN: " + konfirmasiPembayaran.toString());
        konfirmService.updateKonfirmasi(konfirmasiPembayaran);
        model.addAttribute("konfirmasiPembayaran", konfirmasiDto);

       
        return "redirect:/konfirmasi/form_konfirmasi/" + konfirmasiDto.getIdSiswa();
    }
    
     @GetMapping(value = "/getPdf", produces = MediaType.APPLICATION_PDF_VALUE)
    @Transactional
    public @ResponseBody byte[] downloadReport(@RequestParam("cariReport") String cariReport){
        byte[] pdf = report.generatePdfReportKonfirmasi(cariReport);        
        return pdf;
    }

//     @GetMapping("/imageDisplay")
//    public void showImage(HttpServletRequest req, HttpServletResponse response, ) throws IOException {
//         SessionModel sessionModel2 = (SessionModel) req.getSession().getAttribute("sessionModel");
//         String idDaftar = sessionModel2.getIdDaftar();
//         Siswa siswa2 = siswaService.getSiswaByIdDaftar(idDaftar);
//
//        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
//        response.getOutputStream().write(siswa2.getImage());
//
//        response.getOutputStream().close();
//    }
    // show
}
