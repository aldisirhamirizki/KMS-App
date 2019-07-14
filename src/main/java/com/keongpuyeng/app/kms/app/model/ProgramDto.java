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
public class ProgramDto {
    private String idProgram;
    private String namaProgram;
    private Double biaya;

    public ProgramDto(String idProgram, String namaProgram, Double biaya) {
        this.idProgram = idProgram;
        this.namaProgram = namaProgram;
        this.biaya = biaya;
    }

    public ProgramDto() {
    }

    public String getIdProgram() {
        return idProgram;
    }

    public void setIdProgram(String idProgram) {
        this.idProgram = idProgram;
    }

    public String getNamaProgram() {
        return namaProgram;
    }

    public void setNamaProgram(String namaProgram) {
        this.namaProgram = namaProgram;
    }

    public Double getBiaya() {
        return biaya;
    }

    public void setBiaya(Double biaya) {
        this.biaya = biaya;
    }
    
}
