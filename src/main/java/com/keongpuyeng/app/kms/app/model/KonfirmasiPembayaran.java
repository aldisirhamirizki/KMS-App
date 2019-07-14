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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "konfirmasi_pembayaran")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KonfirmasiPembayaran.findAll", query = "SELECT k FROM KonfirmasiPembayaran k"),
    @NamedQuery(name = "KonfirmasiPembayaran.findByIdKonfirmasi", query = "SELECT k FROM KonfirmasiPembayaran k WHERE k.idKonfirmasi = :idKonfirmasi"),
    @NamedQuery(name = "KonfirmasiPembayaran.findByIdSiswa", query = "SELECT k FROM KonfirmasiPembayaran k WHERE k.idSiswa = :idSiswa"),
    @NamedQuery(name = "KonfirmasiPembayaran.findByTglKonfirmasi", query = "SELECT k FROM KonfirmasiPembayaran k WHERE k.tglKonfirmasi = :tglKonfirmasi"),
    @NamedQuery(name = "KonfirmasiPembayaran.findByTotalBiaya", query = "SELECT k FROM KonfirmasiPembayaran k WHERE k.totalBiaya = :totalBiaya"),
    @NamedQuery(name = "KonfirmasiPembayaran.findByIdImage", query = "SELECT k FROM KonfirmasiPembayaran k WHERE k.idImage = :idImage")})
public class KonfirmasiPembayaran implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "id_konfirmasi")
    private String idKonfirmasi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "id_siswa")
    private String idSiswa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tgl_konfirmasi")
    @Temporal(TemporalType.DATE)
    private Date tglKonfirmasi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_biaya")
    private double totalBiaya;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "id_image")
    private String idImage;
    @JoinColumn(name = "bank", referencedColumnName = "id_bank")
    @ManyToOne(optional = false)
    private Bank bank;

    public KonfirmasiPembayaran() {
    }

    public KonfirmasiPembayaran(String idKonfirmasi) {
        this.idKonfirmasi = idKonfirmasi;
    }

    public KonfirmasiPembayaran(String idKonfirmasi, String idSiswa, Date tglKonfirmasi, double totalBiaya, String idImage) {
        this.idKonfirmasi = idKonfirmasi;
        this.idSiswa = idSiswa;
        this.tglKonfirmasi = tglKonfirmasi;
        this.totalBiaya = totalBiaya;
        this.idImage = idImage;
    }

    public String getIdKonfirmasi() {
        return idKonfirmasi;
    }

    public void setIdKonfirmasi(String idKonfirmasi) {
        this.idKonfirmasi = idKonfirmasi;
    }

    public String getIdSiswa() {
        return idSiswa;
    }

    public void setIdSiswa(String idSiswa) {
        this.idSiswa = idSiswa;
    }

    public Date getTglKonfirmasi() {
        return tglKonfirmasi;
    }

    public void setTglKonfirmasi(Date tglKonfirmasi) {
        this.tglKonfirmasi = tglKonfirmasi;
    }

    public double getTotalBiaya() {
        return totalBiaya;
    }

    public void setTotalBiaya(double totalBiaya) {
        this.totalBiaya = totalBiaya;
    }

    public String getIdImage() {
        return idImage;
    }

    public void setIdImage(String idImage) {
        this.idImage = idImage;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKonfirmasi != null ? idKonfirmasi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KonfirmasiPembayaran)) {
            return false;
        }
        KonfirmasiPembayaran other = (KonfirmasiPembayaran) object;
        if ((this.idKonfirmasi == null && other.idKonfirmasi != null) || (this.idKonfirmasi != null && !this.idKonfirmasi.equals(other.idKonfirmasi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.keongpuyeng.app.kms.app.model.KonfirmasiPembayaran[ idKonfirmasi=" + idKonfirmasi + " ]";
    }
    
}
