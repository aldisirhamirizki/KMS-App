/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keongpuyeng.app.kms.app.controller;

import com.google.gson.Gson;
import com.keongpuyeng.app.kms.app.service.ILevelService;
import com.keongpuyeng.app.kms.app.model.Level;
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
@RequestMapping("/level")
public class LevelController {
    private static final Logger LOG = Logger.getLogger(BankController.class);

    @Autowired
    private ILevelService levelService;
    
    @GetMapping("list_level")
    public String listLevel(Model theModel) {
        List<Level> listLevel = levelService.getListLevel();
        theModel.addAttribute("level", listLevel);
        
        for (Level level : listLevel) {
            System.out.println(level.getIdLevel());
            System.out.println(level.getNamaLevel());
            System.out.println(level.getKeterangan());
        }
        
        return "list_level"; // belum ada jsp
}
    @GetMapping("/form_level")
    public String showFormForAdd(Model theModel) {
        LOG.debug("inside show level-form handler method");
        Level level = new Level();
        theModel.addAttribute("level", level);
        return "form_level";
    }
    
    @PostMapping("/saveLevel")
    public String saveLevel(@ModelAttribute("level") Level level) {
               
        String json = new Gson().toJson(level);
        System.out.println(json);
        if(level.getIdLevel() == null || level.getIdLevel().isEmpty()){
            levelService.saveLevel(level);
        }else {
            levelService.updateLevel(level);
        }
        return "redirect:/level/list_level";
    }
    
    @GetMapping("updateLevel")
    public String showFormForUpdate(@RequestParam("idLevel") String theId,
            Model theModel) {
        Level level = levelService.getLevel(theId);
        theModel.addAttribute("level", level);
        return "form_level";
    }
    
    @GetMapping("/delete")
    public String deleteLevel(@RequestParam("idLevel") String theId) {
        levelService.deleteLevel(theId);
        return "redirect:/level/list_level";
    }
}

