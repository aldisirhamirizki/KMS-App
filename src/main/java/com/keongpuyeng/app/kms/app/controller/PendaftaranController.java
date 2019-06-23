/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keongpuyeng.app.kms.app.controller;

import com.google.gson.Gson;
import com.keongpuyeng.app.kms.app.service.IPendaftaranService;
import com.keongpuyeng.app.kms.app.model.Pendaftaran;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Aldis-PC
 */
@Controller
@RequestMapping("/pendaftaran")
public class PendaftaranController {
    
    private static final Logger LOG = Logger.getLogger(PendaftaranController.class);
    
    @Autowired
    private IPendaftaranService pendService;
    
    @GetMapping("list")
    public String listPdftr(Model theModel) {
        List<Pendaftaran> listPdftr = pendService.getListPendaftaran();
        theModel.addAttribute("pendaftaran", listPdftr);
        
        for (Pendaftaran pendaftaran : listPdftr) {
            System.out.println(pendaftaran.getNamaSiswa());
            System.out.println(pendaftaran.getEmailSiswa());
        }
        
        return "list-pendaftaran"; // belum ada jsp
}
    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        LOG.debug("inside show bank-form handler method");
        Pendaftaran pendaftaran = new Pendaftaran();
        theModel.addAttribute("pendaftaran", pendaftaran);
        return "form_pendaftaran";
    }
    
    @PostMapping("/savePendaftaran")
    public String savePendaftaran(@ModelAttribute("pendaftaran") Pendaftaran pendaftaran) {
               
        String json = new Gson().toJson(pendaftaran);
        System.out.println(json);
        pendService.savePendaftaran(pendaftaran);
        return "redirect:/keong/form_pendaftaran";
    }
}
