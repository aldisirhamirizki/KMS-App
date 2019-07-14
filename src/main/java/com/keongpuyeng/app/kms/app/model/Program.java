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
@Table(name = "program")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Program.findAll", query = "SELECT p FROM Program p"),
    @NamedQuery(name = "Program.findByIdProgram", query = "SELECT p FROM Program p WHERE p.idProgram = :idProgram"),
    @NamedQuery(name = "Program.findByNamaProgram", query = "SELECT p FROM Program p WHERE p.namaProgram = :namaProgram"),
    @NamedQuery(name = "Program.findByBiaya", query = "SELECT p FROM Program p WHERE p.biaya = :biaya")})
public class Program implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "id_program")
    private String idProgram;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "nama_program")
    private String namaProgram;
    @Basic(optional = false)
    @NotNull
    @Column(name = "biaya")
    private double biaya;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProgram")
    private Collection<Siswa> siswaCollection;

    public Program() {
    }

    public Program(String idProgram) {
        this.idProgram = idProgram;
    }

    public Program(String idProgram, String namaProgram, double biaya) {
        this.idProgram = idProgram;
        this.namaProgram = namaProgram;
        this.biaya = biaya;
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
        hash += (idProgram != null ? idProgram.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Program)) {
            return false;
        }
        Program other = (Program) object;
        if ((this.idProgram == null && other.idProgram != null) || (this.idProgram != null && !this.idProgram.equals(other.idProgram))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.keongpuyeng.app.kms.app.model.Program[ idProgram=" + idProgram + " ]";
    }
    
}
