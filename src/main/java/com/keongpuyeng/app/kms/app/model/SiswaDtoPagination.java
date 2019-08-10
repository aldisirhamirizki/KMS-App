/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keongpuyeng.app.kms.app.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 *
 * @author Aldis-PC
 */
@Component
public class SiswaDtoPagination {

    @NotNull
    @NotEmpty(message = "Nama tidak boleh kosong")
    @Column(name = "nama_daftar")
    private String namaDaftar;

    @NotNull
    @NotEmpty(message = "Email tidak boleh kosong")
    @Size(min = 8, max = 30, message = "Panjang karakter min. 8 dan max 30")
    @Email
    private String emailDaftar;

    @Column(name = "id_siswa")
    private String idSiswa;

    @NotNull
    @NotEmpty
    private String idDaftar;

    @NotNull
    @NotEmpty(message = "Pilih menu program")
    //@Pattern(regexp = "none", message = "Pilih menu program")
    private String idProgram;
        
    @NotNull
    @NotEmpty(message = "Pilih menu kursus")
    //@Pattern(regexp = "none", message = "Pilih menu kurusus")
    private String idKursus;
    
    @NotNull
    @NotEmpty(message = "Pilih menu level")
    //@Pattern(regexp = "none", message = "Pilih menu level")
    private String idLevel;
    
    @NotNull
    @Size(min = 1, max = 15, message = "Masukan nomor telepon")
    @Column(name = "telepon")
    private String telepon;

    @NotNull
    @NotEmpty(message = "Pilih jenis kelamin")
    @Column(name = "jenis_kelamin")
    //@Pattern(regexp = "none", message = "Pilih jenis kelamin")
    private String jenisKelamin;

    @NotNull(message = "Mohon isi tanggal lahir Anda")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "tanggal_lahir")
    private Date tanggalLahir;

    @NotNull(message = "Mohon isi tempat tinggal Anda")
    @Size(min = 1, max = 50)
    @Column(name = "tempat_tinggal")
    private String tempatTinggal;

    @NotNull
    @NotEmpty(message = "Pilih menu bank")
    //@Pattern(regexp = "none", message = "Pilih menu bank")
    private String idBank;
    
    private byte[] image;

    private String idKonfirmasi;

    private double totalBiaya;

    @Column(name = "status")
    private String Status;

    @Column(name = "nama_program")
    private String namaProgram;

    @Column(name = "nama_kursus")
    private String namaKursus;

    @Column(name = "nama_level")
    private String namaLevel;
    
    private String namaBank;

    public String getNamaProgram() {
        return namaProgram;
    }

    public void setNamaProgram(String namaProgram) {
        this.namaProgram = namaProgram;
    }

    public String getNamaKursus() {
        return namaKursus;
    }

    public void setNamaKursus(String namaKursus) {
        this.namaKursus = namaKursus;
    }

    public String getNamaLevel() {
        return namaLevel;
    }

    public void setNamaLevel(String namaLevel) {
        this.namaLevel = namaLevel;
    }

    public String getNamaBank() {
        return namaBank;
    }

    public void setNamaBank(String namaBank) {
        this.namaBank = namaBank;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    

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
