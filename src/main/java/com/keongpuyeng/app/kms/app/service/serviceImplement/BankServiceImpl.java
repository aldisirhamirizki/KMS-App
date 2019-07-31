/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keongpuyeng.app.kms.app.service.serviceImplement;

import com.keongpuyeng.app.kms.app.dao.BankDao;
import com.keongpuyeng.app.kms.app.model.Bank;
import com.keongpuyeng.app.kms.app.service.IBankService;
import java.text.DecimalFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Aldis-PC
 */
@Service
public class BankServiceImpl implements IBankService{
    
    @Autowired
    private BankDao bankDao;

    @Override
    //@Transactional
    public List<Bank> getListBank() {
        return bankDao.findAll();
    }

    @Override
    @Transactional
    public void saveBank(Bank bank) {
       bank.setIdBank(bId());
       bankDao.save(bank);
    }

    @Override
    @Transactional
    public Bank getBank(String id) {
        return bankDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void updateBank(Bank bank) {
        bankDao.save(bank);
    }

    @Override
    @Transactional
    public void deleteBank(String id) {
        bankDao.deleteById(id);
    }
    
   private String bId() {
        List<Bank> listBank = bankDao.findAll();
        
        String id = null;
        if (listBank.isEmpty()) {
            id = "B-01";
        }
        else {
            DecimalFormat formatId = new DecimalFormat("B-00");
            String nomorUrut = listBank.stream().reduce((first, second) -> second).orElse(null).getIdBank().substring(2);
            id=formatId.format(Double.parseDouble(nomorUrut)+1);
        }
        return id ;
    
    } 
}
