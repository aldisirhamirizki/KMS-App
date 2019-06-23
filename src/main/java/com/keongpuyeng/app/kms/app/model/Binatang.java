/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keongpuyeng.app.kms.app.model;

/**
 *
 * @author Aldis-PC
 */
public class Binatang {

    private String kaki;
    
    private String suara;
    
    private String makanan;
    
    private String jenis;

    public Binatang(String kaki, String suara, String makanan, String jenis) {
        this.kaki = kaki;
        this.suara = suara;
        this.makanan = makanan;
        this.jenis = jenis;
    }

    public Binatang() {
    }

    
    
    
    public String getKaki() {
        return kaki;
    }

    public void setKaki(String kaki) {
        this.kaki = kaki;
    }

    public String getSuara() {
        return suara;
    }

    public void setSuara(String suara) {
        this.suara = suara;
    }

    public String getMakanan() {
        return makanan;
    }

    public void setMakanan(String makanan) {
        this.makanan = makanan;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
    
    
    
}
