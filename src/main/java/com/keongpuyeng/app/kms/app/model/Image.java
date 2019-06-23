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
@Table(name = "image")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Image.findAll", query = "SELECT i FROM Image i"),
    @NamedQuery(name = "Image.findByIdImage", query = "SELECT i FROM Image i WHERE i.idImage = :idImage"),
    @NamedQuery(name = "Image.findByNamaImage", query = "SELECT i FROM Image i WHERE i.namaImage = :namaImage"),
    @NamedQuery(name = "Image.findByTglUpload", query = "SELECT i FROM Image i WHERE i.tglUpload = :tglUpload")})
public class Image implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "id_image")
    private String idImage;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nama_image")
    private String namaImage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tgl_upload")
    @Temporal(TemporalType.DATE)
    private Date tglUpload;

    public Image() {
    }

    public Image(String idImage) {
        this.idImage = idImage;
    }

    public Image(String idImage, String namaImage, Date tglUpload) {
        this.idImage = idImage;
        this.namaImage = namaImage;
        this.tglUpload = tglUpload;
    }

    public String getIdImage() {
        return idImage;
    }

    public void setIdImage(String idImage) {
        this.idImage = idImage;
    }

    public String getNamaImage() {
        return namaImage;
    }

    public void setNamaImage(String namaImage) {
        this.namaImage = namaImage;
    }

    public Date getTglUpload() {
        return tglUpload;
    }

    public void setTglUpload(Date tglUpload) {
        this.tglUpload = tglUpload;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idImage != null ? idImage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Image)) {
            return false;
        }
        Image other = (Image) object;
        if ((this.idImage == null && other.idImage != null) || (this.idImage != null && !this.idImage.equals(other.idImage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.keongpuyeng.app.kms.app.model.Image[ idImage=" + idImage + " ]";
    }
    
}
