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
@Table(name = "kursus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kursus.findAll", query = "SELECT k FROM Kursus k"),
    @NamedQuery(name = "Kursus.findByIdKursus", query = "SELECT k FROM Kursus k WHERE k.idKursus = :idKursus"),
    @NamedQuery(name = "Kursus.findByNamaKursus", query = "SELECT k FROM Kursus k WHERE k.namaKursus = :namaKursus"),
    @NamedQuery(name = "Kursus.findByBiaya", query = "SELECT k FROM Kursus k WHERE k.biaya = :biaya"),
    @NamedQuery(name = "Kursus.findByKet", query = "SELECT k FROM Kursus k WHERE k.ket = :ket")})
public class Kursus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "id_kursus")
    private String idKursus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "nama_kursus")
    private String namaKursus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "biaya")
    private double biaya;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ket")
    private String ket;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idKursus")
    private Collection<Siswa> siswaCollection;

    public Kursus() {
    }

    public Kursus(String idKursus) {
        this.idKursus = idKursus;
    }

    public Kursus(String idKursus, String namaKursus, double biaya, String ket) {
        this.idKursus = idKursus;
        this.namaKursus = namaKursus;
        this.biaya = biaya;
        this.ket = ket;
    }

    public String getIdKursus() {
        return idKursus;
    }

    public void setIdKursus(String idKursus) {
        this.idKursus = idKursus;
    }

    public String getNamaKursus() {
        return namaKursus;
    }

    public void setNamaKursus(String namaKursus) {
        this.namaKursus = namaKursus;
    }

    public double getBiaya() {
        return biaya;
    }

    public void setBiaya(double biaya) {
        this.biaya = biaya;
    }

    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }

    @XmlTransient
    public Collection<Siswa> getSiswaCollection() {
        return siswaCollection;
    }

    public void setSiswaCollection(Collection<Siswa> siswaCollection) {
        this.siswaCollection = siswaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKursus != null ? idKursus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kursus)) {
            return false;
        }
        Kursus other = (Kursus) object;
        if ((this.idKursus == null && other.idKursus != null) || (this.idKursus != null && !this.idKursus.equals(other.idKursus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.keongpuyeng.app.kms.app.model.Kursus[ idKursus=" + idKursus + " ]";
    }
    
}
