/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keongpuyeng.app.kms.app.model;

import java.util.Date;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Aldis-PC
 */
@Component
public class KonfirmasiDto {

    private String idKonfirmasi;
    private String idSiswa;
    private String namaDaftar;
    private String idBank;
    private String bank;
    private Date TglKonfirmasi;
    private double totalBiaya;
    private byte[] displayImageBukti;
    private MultipartFile imageBukti;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    

    public double getTotalBiaya() {
        return totalBiaya;
    }

    public void setTotalBiaya(double totalBiaya) {
        this.totalBiaya = totalBiaya;
    }

    public Date getTglKonfirmasi() {
        return TglKonfirmasi;
    }

    public void setTglKonfirmasi(Date TglKonfirmasi) {
        this.TglKonfirmasi = TglKonfirmasi;
    }

    public String getIdKonfirmasi() {
        return idKonfirmasi;
    }

    public void setIdKonfirmasi(String idKonfirmasi) {
        this.idKonfirmasi = idKonfirmasi;
    }

    public String getIdSiswa() {
        return idSiswa;
    }

    public void setIdSiswa(String idSiswa) {
        this.idSiswa = idSiswa;
    }

    public String getNamaDaftar() {
        return namaDaftar;
    }

    public void setNamaDaftar(String namaDaftar) {
        this.namaDaftar = namaDaftar;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public MultipartFile getImageBukti() {
        return imageBukti;
    }

    public void setImageBukti(MultipartFile imageBukti) {
        this.imageBukti = imageBukti;
    }

    public String getIdBank() {
        return idBank;
    }

    public void setIdBank(String idBank) {
        this.idBank = idBank;
    }

    public byte[] getDisplayImageBukti() {
        return displayImageBukti;
    }

    public void setDisplayImageBukti(byte[] displayImageBukti) {
        this.displayImageBukti = displayImageBukti;
    }
}
