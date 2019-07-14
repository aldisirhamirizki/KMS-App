/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keongpuyeng.app.kms.app.controller;

import com.google.gson.Gson;
import com.keongpuyeng.app.kms.app.model.Bank;
import com.keongpuyeng.app.kms.app.model.Kursus;
import com.keongpuyeng.app.kms.app.model.Pendaftaran;
import com.keongpuyeng.app.kms.app.model.Program;
import com.keongpuyeng.app.kms.app.model.SessionModel;
import com.keongpuyeng.app.kms.app.model.User;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Aldis-PC
 */
@Controller
@RequestMapping("/keong")
@SessionAttributes("sessionModel")
public class AppController {

    @ModelAttribute("sessionModel")
    public SessionModel getSessionModel() {
        return new SessionModel();
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String indexApp(ModelMap model,
            /*@ModelAttribute("sessionModel") SessionModel sessionModel,*/
            HttpServletRequest req) {
        SessionModel sessionModel2 = (SessionModel) req.getSession().getAttribute("sessionModel");
        System.out.println("SessionModel2: " + new Gson().toJson(sessionModel2));

        Pendaftaran pendaftaran = new Pendaftaran();
        model.addAttribute("pendaftaran", pendaftaran);
        model.addAttribute("login", pendaftaran);
        return "index";
    }

    @RequestMapping(value = "/kursus", method = RequestMethod.GET)
    public String kursusApp(ModelMap model) {
        return "kursus";
    }

    @RequestMapping(value = "/hobi", method = RequestMethod.GET)
    public String hobiApp(ModelMap model) {
        return "hobi";
    }

    @RequestMapping(value = "/profesional", method = RequestMethod.GET)
    public String profesionalApp(ModelMap model) {
        return "profesional";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String aboutApp(ModelMap model) {
        return "about";
    }

    @RequestMapping(value = "/login_admin", method = RequestMethod.GET)
    public String LoginApp(ModelMap model, HttpServletRequest req) {
        User user = new User();

        SessionModel sessionModel2 = (SessionModel) req.getSession().getAttribute("sessionModel");
        System.out.println("SessionModel2: " + new Gson().toJson(sessionModel2));
        model.addAttribute("login2", user);
        return "login_admin";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String dashboardAdminApp(ModelMap model) {
        return "home";
    }

//    @RequestMapping(value = "/profil", method = RequestMethod.GET)
//    public String profilApp(ModelMap model) {
//        return "redirect:/siswa/profil";
//    }
    @RequestMapping(value = "/kursus/list_kursus", method = RequestMethod.GET)
    public String listKursusApp(ModelMap model) {
        return "list_kursus";
    }

//    @RequestMapping(value = "/form_user", method = RequestMethod.GET)
//    public String form_AdminApp(ModelMap model) {
//        model.addAttribute("user", new User());
//        return "form_user";
//    }
//    @Autowired
//    private IUserService uService;
//
//    @GetMapping("/list_user")
//    public String listUser(Model theModel) {
//        List<User> users = uService.getUsers();
//        theModel.addAttribute("user", users);
//        return "list_user"; // belum ada jsp
//    }
//    @GetMapping("/delete")
//    public String deleteUser(@RequestParam("idUser") String theId)
//    {
//        uService.deleteUser(theId);
//        return "redirect:/user/list_user";
//    }
//    @RequestMapping(value = "/list_user", method = RequestMethod.GET)
//    public String list_UserApp(ModelMap model){
//        model.addAttribute("user", new User());
//        return "list_user";
//    }
    @RequestMapping(value = "/form_program", method = RequestMethod.GET)
    public String form_ProgramApp(ModelMap model) {
        model.addAttribute("program", new Program());
        return "form_program";
    }

    @RequestMapping(value = "/form_kursus", method = RequestMethod.GET)
    public String form_KursusApp(ModelMap model) {
        model.addAttribute("kursus", new Kursus());
        return "form_kursus";
    }

    @RequestMapping(value = "/form_bank", method = RequestMethod.GET)
    public String form_BankApp(ModelMap model) {
        model.addAttribute("bank", new Bank());
        return "form_bank";
    }

    @RequestMapping(value = "/form_pendaftaran", method = RequestMethod.GET)
    public String form_PendaftaranApp(ModelMap model) {
        model.addAttribute("pendaftaran", new Pendaftaran());
        return "form_pendaftaran";
    }

}
