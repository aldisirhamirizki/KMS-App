/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keongpuyeng.app.kms.app.controller;

import com.google.gson.Gson;
import com.keongpuyeng.app.kms.app.service.IKursusService;
import com.keongpuyeng.app.kms.app.model.Kursus;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Aldis-PC
 */
@Controller
@RequestMapping("/kursus")
public class KursusController {

    private static final Logger LOG = Logger.getLogger(KursusController.class);
    
    @Autowired
    private IKursusService kurService;
    
    @GetMapping("/list_kursus")    
    public String listKursus(Model theModel) {
        List<Kursus> listKursus = kurService.getListKursus();
        theModel.addAttribute("kursus", listKursus);
        
        for (Kursus kursus : listKursus) {
            System.out.println(kursus.getNamaKursus());
        }
        
        return "list_kursus"; // belum ada jsp
    }
    
    @GetMapping("/form_kursus")
    public String showFormForAdd(Model theModel) {
        LOG.debug("inside show kursus-form handler method");
        Kursus kursus = new Kursus();
        theModel.addAttribute("kursus", kursus);
        return "form_kursus";
    }
    
    @PostMapping("/saveKursus")
    public String saveKursus(@ModelAttribute("kursus") Kursus kursus) {
               
        String json = new Gson().toJson(kursus);
        System.out.println(json);
        if(kursus.getIdKursus() == null || kursus.getIdKursus().isEmpty()){
            kurService.saveKursus(kursus);
        }else {
            kurService.updateKursus(kursus);
        }
        return "redirect:/kursus/list_kursus";
    }
    
    @GetMapping("updateKursus")
    public String showFormForUpdate(@RequestParam("idKursus") String theId,
            Model theModel) {
        Kursus listKursus = kurService.getKursus(theId);
        theModel.addAttribute("kursus", listKursus);
        return "form_kursus";
    }
    
    @GetMapping("/delete")
    public String deleteKursus(@RequestParam("idKursus") String theId) {
        kurService.deleteKursus(theId);
        return "redirect:/kursus/list_kursus";
    }
    
       
    }

