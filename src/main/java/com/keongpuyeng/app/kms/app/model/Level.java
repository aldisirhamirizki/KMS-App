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
@Table(name = "level")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Level.findAll", query = "SELECT l FROM Level l"),
    @NamedQuery(name = "Level.findByIdLevel", query = "SELECT l FROM Level l WHERE l.idLevel = :idLevel"),
    @NamedQuery(name = "Level.findByNamaLevel", query = "SELECT l FROM Level l WHERE l.namaLevel = :namaLevel"),
    @NamedQuery(name = "Level.findByKeterangan", query = "SELECT l FROM Level l WHERE l.keterangan = :keterangan"),
    @NamedQuery(name = "Level.findByBiaya", query = "SELECT l FROM Level l WHERE l.biaya = :biaya")})
public class Level implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "id_level")
    private String idLevel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nama_level")
    private String namaLevel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "keterangan")
    private String keterangan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "biaya")
    private double biaya;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLevel")
    private Collection<Siswa> siswaCollection;

    public Level() {
    }

    public Level(String idLevel) {
        this.idLevel = idLevel;
    }

    public Level(String idLevel, String namaLevel, String keterangan, double biaya) {
        this.idLevel = idLevel;
        this.namaLevel = namaLevel;
        this.keterangan = keterangan;
        this.biaya = biaya;
    }

    public String getIdLevel() {
        return idLevel;
    }

    public void setIdLevel(String idLevel) {
        this.idLevel = idLevel;
    }

    public String getNamaLevel() {
        return namaLevel;
    }

    public void setNamaLevel(String namaLevel) {
        this.namaLevel = namaLevel;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public double getBiaya() {
        return biaya;
    }

    public void setBiaya(double biaya) {
        this.biaya = biaya;
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
        hash += (idLevel != null ? idLevel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Level)) {
            return false;
        }
        Level other = (Level) object;
        if ((this.idLevel == null && other.idLevel != null) || (this.idLevel != null && !this.idLevel.equals(other.idLevel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.keongpuyeng.app.kms.app.model.Level[ idLevel=" + idLevel + " ]";
    }
    
}
