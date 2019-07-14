/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keongpuyeng.app.kms.app.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Aldis-PC
 */
@Entity
@Table(name = "siswa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Siswa.findAll", query = "SELECT s FROM Siswa s"),
    @NamedQuery(name = "Siswa.findByIdSiswa", query = "SELECT s FROM Siswa s WHERE s.idSiswa = :idSiswa"),
    @NamedQuery(name = "Siswa.findByTanggalLahir", query = "SELECT s FROM Siswa s WHERE s.tanggalLahir = :tanggalLahir"),
    @NamedQuery(name = "Siswa.findByJenisKelamin", query = "SELECT s FROM Siswa s WHERE s.jenisKelamin = :jenisKelamin"),
    @NamedQuery(name = "Siswa.findByTelepon", query = "SELECT s FROM Siswa s WHERE s.telepon = :telepon"),
    @NamedQuery(name = "Siswa.findByTempatTinggal", query = "SELECT s FROM Siswa s WHERE s.tempatTinggal = :tempatTinggal")})
public class Siswa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "id_siswa")
    private String idSiswa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "telepon")
    private String telepon;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tempat_tinggal")
    private String tempatTinggal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tanggal_lahir")
    @Temporal(TemporalType.DATE)
    private Date tanggalLahir;
    @Basic(optional = false)
    @NotNull
//    @Size(min = 1, max = 6)
    @Column(name = "jenis_kelamin", columnDefinition = "ENUM('Pria','Wanita')")
    @Enumerated(EnumType.STRING)
    private EnumJenisKelamin jenisKelamin;
    @Column(name = "image", length = 100000)
    private byte[] image;

    @JoinColumn(name = "id_program", referencedColumnName = "id_program")
    @ManyToOne(optional = false)
    private Program idProgram;
    @JoinColumn(name = "id_daftar", referencedColumnName = "id_daftar")
    @ManyToOne(optional = false)
    private Pendaftaran idDaftar;
    @JoinColumn(name = "id_kursus", referencedColumnName = "id_kursus")
    @ManyToOne(optional = false)
    private Kursus idKursus;
    @JoinColumn(name = "id_level", referencedColumnName = "id_level")
    @ManyToOne(optional = false)
    private Level idLevel;
    @JoinColumn(name = "id_bank", referencedColumnName = "id_bank")
    @ManyToOne(optional = false)
    private Bank idBank;

    public Siswa() {
    }

    public Siswa(String idSiswa) {
        this.idSiswa = idSiswa;
    }

    public Siswa(String idSiswa, Date tanggalLahir, EnumJenisKelamin jenisKelamin, String telepon, String tempatTinggal) {
        this.idSiswa = idSiswa;
        this.tanggalLahir = tanggalLahir;
        this.jenisKelamin = jenisKelamin;
        this.telepon = telepon;
        this.tempatTinggal = tempatTinggal;
    }

    public String getIdSiswa() {
        return idSiswa;
    }

    public void setIdSiswa(String idSiswa) {
        this.idSiswa = idSiswa;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public EnumJenisKelamin getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(EnumJenisKelamin jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Program getIdProgram() {
        return idProgram;
    }

    public void setIdProgram(Program idProgram) {
        this.idProgram = idProgram;
    }

    public Pendaftaran getIdDaftar() {
        return idDaftar;
    }

    public void setIdDaftar(Pendaftaran idDaftar) {
        this.idDaftar = idDaftar;
    }

    public Kursus getIdKursus() {
        return idKursus;
    }

    public void setIdKursus(Kursus idKursus) {
        this.idKursus = idKursus;
    }

    public Level getIdLevel() {
        return idLevel;
    }

    public void setIdLevel(Level idLevel) {
        this.idLevel = idLevel;
    }

    public Bank getIdBank() {
        return idBank;
    }

    public void setIdBank(Bank idBank) {
        this.idBank = idBank;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSiswa != null ? idSiswa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Siswa)) {
            return false;
        }
        Siswa other = (Siswa) object;
        if ((this.idSiswa == null && other.idSiswa != null) || (this.idSiswa != null && !this.idSiswa.equals(other.idSiswa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.keongpuyeng.app.kms.app.model.Siswa[ idSiswa=" + idSiswa + " ]";
    }

}
