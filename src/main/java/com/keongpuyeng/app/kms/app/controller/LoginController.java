/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keongpuyeng.app.kms.app.controller;

import com.google.gson.Gson;
import com.keongpuyeng.app.kms.app.model.ErrorMessage;
import com.keongpuyeng.app.kms.app.model.Pendaftaran;
import com.keongpuyeng.app.kms.app.model.SessionModel;
import com.keongpuyeng.app.kms.app.model.User;
import com.keongpuyeng.app.kms.app.model.ValidationResponse;
import com.keongpuyeng.app.kms.app.param.Param;
import com.keongpuyeng.app.kms.app.service.IPendaftaranService;
import com.keongpuyeng.app.kms.app.service.IUserService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Aldis-PC
 */
@Controller
@RequestMapping("/login")
//@SessionAttributes("sessionModel")
public class LoginController {

    @Autowired
    private IPendaftaranService pendaftaranSvc;

    @Autowired
    private IUserService userService;

    @PostMapping("/adminLogin")
    public @ResponseBody
    String adminLogin(Model model, @ModelAttribute("user") @Valid User user,
            BindingResult bindingResult, HttpServletRequest request) {
        String send2 = "";
        System.out.println("User:  " + new Gson().toJson(user));
        ValidationResponse resp = new ValidationResponse();
        if (bindingResult.hasErrors()) {
            resp.setStatus(Param.FAIL);
            List<FieldError> allErrors = bindingResult.getFieldErrors();
            final List<ErrorMessage> errorMessages = new ArrayList<>();
            for (FieldError objectError : allErrors) {
                errorMessages.add(new ErrorMessage(objectError.getField(),
                        objectError.getDefaultMessage()));
            }
            resp.setListErrorMessages(errorMessages);
            resp.setRedirectUrl(null);

            return new Gson().toJson(resp);
        }

        User u = userService.getLogin(user);

        if (u == null) {
            resp.setStatus(Param.FAIL);
            List<ErrorMessage> errorMessages = new ArrayList<>();
            errorMessages.add(new ErrorMessage("loginNotif", "Email atau password tidak valid"));
            resp.setListErrorMessages(errorMessages);

            send2 = new Gson().toJson(resp);
        } else {
        model.addAttribute("login2", user);
            SessionModel sessionModel = new SessionModel();
            sessionModel.setIdUser(u.getIdUser());
            sessionModel.setNamaUser(u.getNamaUser());
            sessionModel.setEmailUser(u.getEmailUser());

            System.out.println("Session Model Value: " + new Gson().toJson(sessionModel));

            request.getSession().setAttribute("sessionModel", sessionModel);
            resp.setStatus(Param.SUCCESS);
            resp.setListErrorMessages(null);
            resp.setRedirectUrl(request.getContextPath() + "/keong/admin");

            send2 = new Gson().toJson(resp);
        }
        return send2;
    }

    @PostMapping("/doLogin")
    public @ResponseBody
    String doLogin(Model model,
            @ModelAttribute("pendaftaran") @Valid Pendaftaran pendaftaran,
            BindingResult bindingResult, HttpServletRequest request) {
        String send = "";
        System.out.println("Pendaftaran: " + new Gson().toJson(pendaftaran));
        // System.out.println("Session Model: " + new Gson().toJson(sessionModel));

        // insert Pendaftaran to SessionModel
        ValidationResponse res = new ValidationResponse();
        if (bindingResult.hasErrors()) {
            res.setStatus(Param.FAIL);
            List<FieldError> allErrors = bindingResult.getFieldErrors();
            final List<ErrorMessage> errorMessages = new ArrayList<>();
            for (FieldError objectError : allErrors) {
                errorMessages.add(new ErrorMessage(objectError.getField(), objectError.getDefaultMessage()));
            }
            res.setListErrorMessages(errorMessages);
            res.setRedirectUrl(null);

            return new Gson().toJson(res);
        }

        Pendaftaran p = pendaftaranSvc.getLogin(pendaftaran);

        if (p == null) {
            // login failed, show error message in jsp
            res.setStatus(Param.FAIL);
            List<ErrorMessage> errorMessages = new ArrayList<>();
            errorMessages.add(new ErrorMessage("loginNotif", "Email atau password tidak valid"));
            res.setListErrorMessages(errorMessages);

            send = new Gson().toJson(res);
        } else {
            // login success, show notification success in jsp
            // set session with user
            SessionModel sessionModel = new SessionModel();
            sessionModel.setIdDaftar(p.getIdDaftar());
            sessionModel.setNamaDaftar(p.getNamaDaftar());
            sessionModel.setEmailDaftar(p.getEmailDaftar());

            System.out.println("Session Model Value: " + new Gson().toJson(sessionModel));

            // model.addAttribute("sessionModel", sessionModel);
            request.getSession().setAttribute("sessionModel", sessionModel);
            res.setStatus(Param.SUCCESS);
            res.setListErrorMessages(null);
            res.setRedirectUrl(request.getContextPath() + "/keong/index");

            send = new Gson().toJson(res);
        }

        return send;
    }

    @GetMapping("/logout")
    public String doLogout(HttpServletRequest req) {
        req.getSession().removeAttribute("sessionModel");
        return "redirect:/keong/index";
    }
    
    @GetMapping("/logoutAdmin")
    public String logoutAdmin(HttpServletRequest req) {
        req.getSession().removeAttribute("sessionModel");
        return "redirect:/keong/login_admin";
    }
}
