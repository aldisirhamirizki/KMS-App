/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keongpuyeng.app.kms.app.dao;

import com.keongpuyeng.app.kms.app.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Aldis-PC
 */
@Repository
public interface BankDao extends JpaRepository<Bank, Object>{
    
}
