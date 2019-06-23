/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keongpuyeng.app.kms.app.controller;

import com.keongpuyeng.app.kms.app.model.Bank;
import com.keongpuyeng.app.kms.app.model.Kursus;
import com.keongpuyeng.app.kms.app.model.Pendaftaran;
import com.keongpuyeng.app.kms.app.model.Program;
import com.keongpuyeng.app.kms.app.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Aldis-PC
 */
@Controller
@RequestMapping("/keong")
public class AppController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String indexApp(ModelMap model){
        return "index";
    }
    
    @RequestMapping(value = "/kursus", method = RequestMethod.GET)
    public String kursusApp(ModelMap model){
        return "kursus";
    }
    
    @RequestMapping(value = "/hobi", method = RequestMethod.GET)
    public String hobiApp(ModelMap model){
        return "hobi";
    }
    
    @RequestMapping(value = "/profesional", method = RequestMethod.GET)
    public String profesionalApp(ModelMap model){
        return "profesional";
    }
    
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String aboutApp(ModelMap model){
        return "about";
    }
    
    @RequestMapping(value = "/login_user", method = RequestMethod.GET)
    public String Login_AdminApp(ModelMap model){
        return "login_user";
    }
    
    @RequestMapping(value = "/form_user", method = RequestMethod.GET)
    public String form_AdminApp(ModelMap model){
        model.addAttribute("user", new User());
        return "form_user";
    }
    
    @RequestMapping(value = "/form_program", method = RequestMethod.GET)
    public String form_ProgramApp(ModelMap model){
        model.addAttribute("program", new Program());
        return "form_program";
    }
    
    @RequestMapping(value = "/form_kursus", method = RequestMethod.GET)
    public String form_KursusApp(ModelMap model){
        model.addAttribute("kursus", new Kursus());
        return "form_kursus";
    }
    
    @RequestMapping(value = "/form_bank", method = RequestMethod.GET)
    public String form_BankApp(ModelMap model){
        model.addAttribute("bank", new Bank());
        return "form_bank";
    }
    
    @RequestMapping(value = "/form_pendaftaran", method = RequestMethod.GET)
    public String form_PendaftaranApp(ModelMap model){
        model.addAttribute("pendaftaran", new Pendaftaran());
        return "form_pendaftaran";
    }
    
    
}
