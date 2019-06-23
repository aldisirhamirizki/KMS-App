/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keongpuyeng.app.kms.app.service;

import com.keongpuyeng.app.kms.app.model.Bank;
import java.util.List;

/**
 *
 * @author Aldis-PC
 */
public interface IBankService {
    
    public List<Bank> getListBank();
    
    public void saveBank(Bank bank);
    
    public Bank getBank(String id);
    
    public void updateBank(Bank bank);
    
    public void deleteBank(String id);
}
