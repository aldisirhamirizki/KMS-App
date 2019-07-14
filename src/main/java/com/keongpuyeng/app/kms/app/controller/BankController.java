/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keongpuyeng.app.kms.app.controller;

import com.google.gson.Gson;
import com.keongpuyeng.app.kms.app.service.IBankService;
import com.keongpuyeng.app.kms.app.model.Bank;
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
@RequestMapping("/bank")
public class BankController {
    
    private static final Logger LOG = Logger.getLogger(BankController.class);

    @Autowired
    private IBankService bankService;
    
    @GetMapping("list_bank")
    public String listBank(Model theModel) {
        List<Bank> listBank = bankService.getListBank();
        theModel.addAttribute("bank", listBank);
        
        for (Bank bank : listBank) {
            System.out.println(bank.getIdBank());
            System.out.println(bank.getNamaBank());
            System.out.println(bank.getRekening());
        }
        
        return "list_bank"; // belum ada jsp
}
    @GetMapping("/form_bank")
    public String showFormForAdd(Model theModel) {
        LOG.debug("inside show bank-form handler method");
        Bank bank = new Bank();
        theModel.addAttribute("bank", bank);
        return "form_bank";
    }
    
    @PostMapping("/saveBank")
    public String saveBank(@ModelAttribute("bank") Bank bank) {
               
        String json = new Gson().toJson(bank);
        System.out.println(json);
        if(bank.getIdBank() == null || bank.getIdBank().isEmpty()){
            bankService.saveBank(bank);
        }else {
            bankService.updateBank(bank);
        }
        return "redirect:/bank/list_bank";
    }
    
    @GetMapping("updateBank")
    public String showFormForUpdate(@RequestParam("idBank") String theId,
            Model theModel) {
        Bank bank = bankService.getBank(theId);
        theModel.addAttribute("bank", bank);
        return "form_bank";
    }
    
    @GetMapping("/delete")
    public String deleteBank(@RequestParam("idBank") String theId) {
        bankService.deleteBank(theId);
        return "redirect:/bank/list_bank";
    }
}
