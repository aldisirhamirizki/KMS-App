/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keongpuyeng.app.kms.app.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Aldis-PC
 */
@Entity
@Table(name = "pendaftaran")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pendaftaran.findAll", query = "SELECT p FROM Pendaftaran p"),
    @NamedQuery(name = "Pendaftaran.findByIdSiswa", query = "SELECT p FROM Pendaftaran p WHERE p.idSiswa = :idSiswa"),
    @NamedQuery(name = "Pendaftaran.findByNamaSiswa", query = "SELECT p FROM Pendaftaran p WHERE p.namaSiswa = :namaSiswa"),
    @NamedQuery(name = "Pendaftaran.findByEmailSiswa", query = "SELECT p FROM Pendaftaran p WHERE p.emailSiswa = :emailSiswa"),
    @NamedQuery(name = "Pendaftaran.findByPasswordSiswa", query = "SELECT p FROM Pendaftaran p WHERE p.passwordSiswa = :passwordSiswa"),
    @NamedQuery(name = "Pendaftaran.findByTeleponSiswa", query = "SELECT p FROM Pendaftaran p WHERE p.teleponSiswa = :teleponSiswa"),
    @NamedQuery(name = "Pendaftaran.findByProgram", query = "SELECT p FROM Pendaftaran p WHERE p.program = :program"),
    @NamedQuery(name = "Pendaftaran.findByKursus", query = "SELECT p FROM Pendaftaran p WHERE p.kursus = :kursus"),
    @NamedQuery(name = "Pendaftaran.findByIdImage", query = "SELECT p FROM Pendaftaran p WHERE p.idImage = :idImage")})
public class Pendaftaran implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "id_siswa")
    private String idSiswa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nama_siswa")
    private String namaSiswa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "email_siswa")
    private String emailSiswa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "password_siswa")
    private String passwordSiswa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "telepon_siswa")
    private String teleponSiswa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "program")
    private String program;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "kursus")
    private String kursus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "id_image")
    private String idImage;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSiswa")
    private Collection<KonfirmasiPembayaran> konfirmasiPembayaranCollection;

    public Pendaftaran() {
    }

    public Pendaftaran(String idSiswa) {
        this.idSiswa = idSiswa;
    }

    public Pendaftaran(String idSiswa, String namaSiswa, String emailSiswa, String passwordSiswa, String teleponSiswa, String program, String kursus, String idImage) {
        this.idSiswa = idSiswa;
        this.namaSiswa = namaSiswa;
        this.emailSiswa = emailSiswa;
        this.passwordSiswa = passwordSiswa;
        this.teleponSiswa = teleponSiswa;
        this.program = program;
        this.kursus = kursus;
        this.idImage = idImage;
    }

    public String getIdSiswa() {
        return idSiswa;
    }

    public void setIdSiswa(String idSiswa) {
        this.idSiswa = idSiswa;
    }

    public String getNamaSiswa() {
        return namaSiswa;
    }

    public void setNamaSiswa(String namaSiswa) {
        this.namaSiswa = namaSiswa;
    }

    public String getEmailSiswa() {
        return emailSiswa;
    }

    public void setEmailSiswa(String emailSiswa) {
        this.emailSiswa = emailSiswa;
    }

    public String getPasswordSiswa() {
        return passwordSiswa;
    }

    public void setPasswordSiswa(String passwordSiswa) {
        this.passwordSiswa = passwordSiswa;
    }

    public String getTeleponSiswa() {
        return teleponSiswa;
    }

    public void setTeleponSiswa(String teleponSiswa) {
        this.teleponSiswa = teleponSiswa;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getKursus() {
        return kursus;
    }

    public void setKursus(String kursus) {
        this.kursus = kursus;
    }

    public String getIdImage() {
        return idImage;
    }

    public void setIdImage(String idImage) {
        this.idImage = idImage;
    }

    @XmlTransient
    public Collection<KonfirmasiPembayaran> getKonfirmasiPembayaranCollection() {
        return konfirmasiPembayaranCollection;
    }

    public void setKonfirmasiPembayaranCollection(Collection<KonfirmasiPembayaran> konfirmasiPembayaranCollection) {
        this.konfirmasiPembayaranCollection = konfirmasiPembayaranCollection;
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
        if (!(object instanceof Pendaftaran)) {
            return false;
        }
        Pendaftaran other = (Pendaftaran) object;
        if ((this.idSiswa == null && other.idSiswa != null) || (this.idSiswa != null && !this.idSiswa.equals(other.idSiswa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.keongpuyeng.app.kms.app.model.Pendaftaran[ idSiswa=" + idSiswa + " ]";
    }
    
}
