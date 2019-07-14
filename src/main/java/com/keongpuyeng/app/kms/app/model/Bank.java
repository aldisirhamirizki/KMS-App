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
@Table(name = "bank")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bank.findAll", query = "SELECT b FROM Bank b"),
    @NamedQuery(name = "Bank.findByIdBank", query = "SELECT b FROM Bank b WHERE b.idBank = :idBank"),
    @NamedQuery(name = "Bank.findByNamaBank", query = "SELECT b FROM Bank b WHERE b.namaBank = :namaBank"),
    @NamedQuery(name = "Bank.findByRekening", query = "SELECT b FROM Bank b WHERE b.rekening = :rekening")})
public class Bank implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "id_bank")
    private String idBank;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "nama_bank")
    private String namaBank;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "rekening")
    private String rekening;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bank")
    private Collection<KonfirmasiPembayaran> konfirmasiPembayaranCollection;

    public Bank() {
    }

    public Bank(String idBank) {
        this.idBank = idBank;
    }

    public Bank(String idBank, String namaBank, String rekening) {
        this.idBank = idBank;
        this.namaBank = namaBank;
        this.rekening = rekening;
    }

    public String getIdBank() {
        return idBank;
    }

    public void setIdBank(String idBank) {
        this.idBank = idBank;
    }

    public String getNamaBank() {
        return namaBank;
    }

    public void setNamaBank(String namaBank) {
        this.namaBank = namaBank;
    }

    public String getRekening() {
        return rekening;
    }

    public void setRekening(String rekening) {
        this.rekening = rekening;
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
        hash += (idBank != null ? idBank.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bank)) {
            return false;
        }
        Bank other = (Bank) object;
        if ((this.idBank == null && other.idBank != null) || (this.idBank != null && !this.idBank.equals(other.idBank))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.keongpuyeng.app.kms.app.model.Bank[ idBank=" + idBank + " ]";
    }
    
}
