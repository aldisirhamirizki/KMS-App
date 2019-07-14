/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keongpuyeng.app.kms.app.controller;

import com.google.gson.Gson;
import com.keongpuyeng.app.kms.app.model.ErrorMessage;
import com.keongpuyeng.app.kms.app.service.IPendaftaranService;
import com.keongpuyeng.app.kms.app.model.Pendaftaran;
import com.keongpuyeng.app.kms.app.model.ValidationResponse;
import com.keongpuyeng.app.kms.app.param.Param;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.apache.log4j.Logger;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
            System.out.println(pendaftaran.getNamaDaftar());
            System.out.println(pendaftaran.getEmailDaftar());
        }

        return "list_pendaftaran"; // belum ada jsp
    }

    @GetMapping("/daftar")
    public String showFormForAdd(Model theModel) {
        LOG.debug("inside show bank-form handler method");
        Pendaftaran pendaftaran = new Pendaftaran();
        theModel.addAttribute("pendaftaran", pendaftaran);
        return "daftar";
    }

    @PostMapping("/savePendaftaran")
    public @ResponseBody String savePendaftaran(@ModelAttribute("pendaftaran") @Valid Pendaftaran pendaftaran,
            BindingResult bindingResult, RedirectAttributes redirectAttributes, HttpServletRequest request) {

        System.out.println("Pendaftaran: " + new Gson().toJson(pendaftaran));
        ValidationResponse res = new ValidationResponse();
        if (bindingResult.hasErrors()) {

            res.setStatus(Param.FAIL);
            List<FieldError> allErrors = bindingResult.getFieldErrors();
            final List<ErrorMessage> errorMessages = new ArrayList<ErrorMessage>();
            for (FieldError objectError : allErrors) {
                errorMessages.add(new ErrorMessage(objectError.getField(), objectError.getDefaultMessage()));
            }
            res.setListErrorMessages(errorMessages);
            res.setRedirectUrl(null);
            
            return new Gson().toJson(res);
        }

        if (pendaftaran.getIdDaftar() == null || pendaftaran.getIdDaftar().isEmpty()) {
            boolean success = pendService.savePendaftaran(pendaftaran);
            if (success) {
                res.setStatus(Param.SUCCESS);
                res.setListErrorMessages(null);
                res.setRedirectUrl(request.getContextPath() + "/keong/index");                
            }

        } else {
            pendService.updatePendaftaran(pendaftaran);
        }
//        return "redirect:/keong/index";
        return new Gson().toJson(res);
    }

}
