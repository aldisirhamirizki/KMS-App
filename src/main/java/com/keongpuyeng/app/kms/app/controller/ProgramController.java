/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keongpuyeng.app.kms.app.controller;

import com.google.gson.Gson;
import com.keongpuyeng.app.kms.app.service.IProgramService;
import com.keongpuyeng.app.kms.app.model.Program;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Aldis-PC
 */
@Controller
@RequestMapping("/program")
public class ProgramController {

    private static final Logger LOG = Logger.getLogger(UserController.class);

    @Autowired
    private IProgramService progService;

    @GetMapping("/list_program")
    public String listProgram(Model theModel) {
        List<Program> listProg = progService.getListPrograms();
        theModel.addAttribute("program", listProg);
        return "list_program"; 
    }

    @GetMapping("/form_program")
    public String showFormForAdd(Model theModel) {
        LOG.debug("inside show program-form handler method");
        Program program = new Program();
        theModel.addAttribute("program", program);
        return "form_program";
    }

    @PostMapping("/saveProgram")
    public String saveProgram(@ModelAttribute("program") Program program) {

        String json = new Gson().toJson(program);
        System.out.println(json);
        if(program.getIdProgram() == null || program.getIdProgram().isEmpty()){
            progService.saveProgram(program);
        }else {
            progService.updateProgram(program);
        }
        return "redirect:/program/list_program";
    }
    
    @GetMapping("updateProgram")
    public String showFormForUpdate(@RequestParam("idProgram") String theId,
            Model theModel) {
        Program programs = progService.getProgram(theId);
        theModel.addAttribute("program", programs);
        return "form_program";
    }

    @GetMapping("/delete")
    public String deleteProg(@RequestParam("idProgram") String theId) {
        progService.deleteProgram(theId);
        return "redirect:/program/list_program";
    }
}
