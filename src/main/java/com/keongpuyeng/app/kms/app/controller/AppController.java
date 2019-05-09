/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keongpuyeng.app.kms.app.controller;

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
}
