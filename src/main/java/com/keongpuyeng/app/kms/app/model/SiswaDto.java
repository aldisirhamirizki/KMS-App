/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keongpuyeng.app.kms.app.model;

import com.mysql.cj.jdbc.Blob;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

/**
 *
 * @author Aldis-PC
 */
@Component
public class SiswaDto {

    @NotNull
    @NotEmpty(message = "harus diisi")
    private String namaDaftar;

    @NotNull
    @NotEmpty(message = "harus diisi")
    @Size(min = 1, max = 30)
    @Email
    private String emailDaftar;
    
    private String idSiswa;

    @NotNull
    @NotEmpty
    private String idDaftar;

    @NotNull
    @NotEmpty
    private String idProgram;
    
    @NotNull
    @NotEmpty
    private String idKursus;
    
    @NotNull
    @NotEmpty
    private String idLevel;
    
    @NotNull
    @Size(min = 1, max = 15)
    private String telepon;

    @NotNull
    @NotEmpty
    private String jenisKelamin;
        
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tanggalLahir;
   
    private String tempatTinggal;

    private String idBank;
    
    private byte[] image;
    
    private String idKonfirmasi;

    private double totalBiaya;

    public String getIdKonfirmasi() {
        return idKonfirmasi;
    }

    public void setIdKonfirmasi(String idKonfirmasi) {
        this.idKonfirmasi = idKonfirmasi;
    }

    public double getTotalBiaya() {
        return totalBiaya;
    }

    public void setTotalBiaya(double totalBiaya) {
        this.totalBiaya = totalBiaya;
    }

    
    
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    

   
   

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
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

    public String getIdSiswa() {
        return idSiswa;
    }

    public void setIdSiswa(String idSiswa) {
        this.idSiswa = idSiswa;
    }

    
    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getTempatTinggal() {
        return tempatTinggal;
    }

    public void setTempatTinggal(String tempatTinggal) {
        this.tempatTinggal = tempatTinggal;
    }

    public String getIdDaftar() {
        return idDaftar;
    }

    public void setIdDaftar(String idDaftar) {
        this.idDaftar = idDaftar;
    }

    public String getIdProgram() {
        return idProgram;
    }

    public void setIdProgram(String idProgram) {
        this.idProgram = idProgram;
    }

    public String getIdKursus() {
        return idKursus;
    }

    public void setIdKursus(String idKursus) {
        this.idKursus = idKursus;
    }

    public String getIdLevel() {
        return idLevel;
    }

    public void setIdLevel(String idLevel) {
        this.idLevel = idLevel;
    }

    public String getIdBank() {
        return idBank;
    }

    public void setIdBank(String idBank) {
        this.idBank = idBank;
    }
}