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
    @NamedQuery(name = "KonfirmasiPembayaran.findByTglKonfirmasi", query = "SELECT k FROM KonfirmasiPembayaran k WHERE k.tglKonfirmasi = :tglKonfirmasi"),
    @NamedQuery(name = "KonfirmasiPembayaran.findByKet", query = "SELECT k FROM KonfirmasiPembayaran k WHERE k.ket = :ket"),
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
    @Column(name = "tgl_konfirmasi")
    @Temporal(TemporalType.DATE)
    private Date tglKonfirmasi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ket")
    private String ket;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "id_image")
    private String idImage;
    @JoinColumn(name = "id_siswa", referencedColumnName = "id_siswa")
    @ManyToOne(optional = false)
    private Pendaftaran idSiswa;

    public KonfirmasiPembayaran() {
    }

    public KonfirmasiPembayaran(String idKonfirmasi) {
        this.idKonfirmasi = idKonfirmasi;
    }

    public KonfirmasiPembayaran(String idKonfirmasi, Date tglKonfirmasi, String ket, String idImage) {
        this.idKonfirmasi = idKonfirmasi;
        this.tglKonfirmasi = tglKonfirmasi;
        this.ket = ket;
        this.idImage = idImage;
    }

    public String getIdKonfirmasi() {
        return idKonfirmasi;
    }

    public void setIdKonfirmasi(String idKonfirmasi) {
        this.idKonfirmasi = idKonfirmasi;
    }

    public Date getTglKonfirmasi() {
        return tglKonfirmasi;
    }

    public void setTglKonfirmasi(Date tglKonfirmasi) {
        this.tglKonfirmasi = tglKonfirmasi;
    }

    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }

    public String getIdImage() {
        return idImage;
    }

    public void setIdImage(String idImage) {
        this.idImage = idImage;
    }

    public Pendaftaran getIdSiswa() {
        return idSiswa;
    }

    public void setIdSiswa(Pendaftaran idSiswa) {
        this.idSiswa = idSiswa;
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
