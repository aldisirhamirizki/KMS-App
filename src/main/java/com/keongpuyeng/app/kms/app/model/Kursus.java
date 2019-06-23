/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keongpuyeng.app.kms.app.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

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
    @NamedQuery(name = "Kursus.findByNamaKursus", query = "SELECT k FROM Kursus k WHERE k.namaKursus = :namaKursus")})
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

    public Kursus() {
    }

    public Kursus(String idKursus) {
        this.idKursus = idKursus;
    }

    public Kursus(String idKursus, String namaKursus) {
        this.idKursus = idKursus;
        this.namaKursus = namaKursus;
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
