/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keongpuyeng.app.kms.app.model;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author Aldis-PC
 */
public class SessionModel {
    
    //pendaftar
    private String idDaftar;
    private String namaDaftar;
    private String emailDaftar;
    private String password;
    
    //user
    private String idUser;
    private String namaUser;
    private String emailUser;
    private String passwordUser;
    

    public String getIdDaftar() {
        return idDaftar;
    }

    public void setIdDaftar(String idDaftar) {
        this.idDaftar = idDaftar;
    }

    public String getNamaDaftar() {
        return namaDaftar;
    }

    public void setNamaDaftar(String namaDaftar) {
        this.namaDaftar = namaDaftar;
    }

    public String getEmailDaftar() {
        return emailDaftar;
    }

    public void setEmailDaftar(String emailDaftar) {
        this.emailDaftar = emailDaftar;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    //user

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getNamaUser() {
        return namaUser;
    }

    public void setNamaUser(String namaUser) {
        this.namaUser = namaUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }
    
    
}
