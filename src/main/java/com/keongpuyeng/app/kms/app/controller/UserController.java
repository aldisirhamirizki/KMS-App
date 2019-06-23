/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keongpuyeng.app.kms.app.controller;

import com.google.gson.Gson;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.keongpuyeng.app.kms.app.model.User;
import com.keongpuyeng.app.kms.app.service.IUserService;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Aldis-PC
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger LOG = Logger.getLogger(UserController.class);

    @Autowired
    private IUserService uService;

    @GetMapping("/list")    
    public String listUser(Model theModel) {
        List<User> users = uService.getUsers();
        theModel.addAttribute("users", users);
        
        for (User user : users) {
            System.out.println(user.getNamaUser());
            System.out.println(user.getEmailUser());
            System.out.println(user.getPasswordUser());
        }
        
        return "list-users"; // belum ada jsp
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        LOG.debug("inside show user-form handler method");
        User Users = new User();
        theModel.addAttribute("user", Users);
        return "form_user";
    }

    @PostMapping("/saveUser")
//    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user) {
               
        // 
        
        String json = new Gson().toJson(user);
        System.out.println(json);
        uService.saveUser(user);
        return "redirect:/keong/form_user";
    }
    
    @GetMapping("updateForm")
    public String showFormForUpdate(@RequestParam("customerId") String theId,
            Model theModel) {
        User Users = uService.getUser(theId);
        theModel.addAttribute("user", Users);
        return "form_user";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("userId") String theId) {
        uService.deleteUser(theId);
        return "redirect:/user/list";
    }
}
