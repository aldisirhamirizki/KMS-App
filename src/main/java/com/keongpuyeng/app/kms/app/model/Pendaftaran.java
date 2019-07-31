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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Aldis-PC
 */
@Entity
@Table(name = "pendaftaran")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pendaftaran.findAll", query = "SELECT p FROM Pendaftaran p"),
    @NamedQuery(name = "Pendaftaran.findByIdDaftar", query = "SELECT p FROM Pendaftaran p WHERE p.idDaftar = :idDaftar"),
    @NamedQuery(name = "Pendaftaran.findByNamaDaftar", query = "SELECT p FROM Pendaftaran p WHERE p.namaDaftar = :namaDaftar"),
    @NamedQuery(name = "Pendaftaran.findByEmailDaftar", query = "SELECT p FROM Pendaftaran p WHERE p.emailDaftar = :emailDaftar"),
    @NamedQuery(name = "Pendaftaran.findByPasswordDaftar", query = "SELECT p FROM Pendaftaran p WHERE p.passwordDaftar = :passwordDaftar")})
public class Pendaftaran implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
//    @Size(min = 1, max = 15)
    @Column(name = "id_daftar")
    private String idDaftar;
    @Basic(optional = false)
    @NotNull
    @NotEmpty(message = "harus diisi")
//    @Size(min = 1, max = 50)
    @Column(name = "nama_daftar")
    private String namaDaftar;
    @Basic(optional = false)
    @NotNull
    @NotEmpty(message = "harus diisi")
    @Size(min = 1, max = 30)
    @Email
    @Column(name = "email_daftar")
    private String emailDaftar;
    @Basic(optional = false)
    @NotNull
    @NotEmpty(message = "harus diisi")
    @Size(min = 1, max = 30)
    @Column(name = "password_daftar")
    private String passwordDaftar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDaftar", fetch = FetchType.LAZY)
    private Collection<Siswa> siswaCollection;

    public Pendaftaran() {
    }

    public Pendaftaran(String idDaftar) {
        this.idDaftar = idDaftar;
    }

    public Pendaftaran(String idDaftar, String namaDaftar, String emailDaftar, String passwordDaftar) {
        this.idDaftar = idDaftar;
        this.namaDaftar = namaDaftar;
        this.emailDaftar = emailDaftar;
        this.passwordDaftar = passwordDaftar;
    }

    public String getIdDaftar() {
        return idDaftar;
    }

    public void setIdDaftar(String idDaftar) {
        this.idDaftar = idDaftar;
    }

    public String getNamaDaftar() {
        return namaDaftar;
    }

    public void setNamaDaftar(String namaDaftar) {
        this.namaDaftar = namaDaftar;
    }

    public String getEmailDaftar() {
        return emailDaftar;
    }

    public void setEmailDaftar(String emailDaftar) {
        this.emailDaftar = emailDaftar;
    }

    public String getPasswordDaftar() {
        return passwordDaftar;
    }

    public void setPasswordDaftar(String passwordDaftar) {
        this.passwordDaftar = passwordDaftar;
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
        hash += (idDaftar != null ? idDaftar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pendaftaran)) {
            return false;
        }
        Pendaftaran other = (Pendaftaran) object;
        if ((this.idDaftar == null && other.idDaftar != null) || (this.idDaftar != null && !this.idDaftar.equals(other.idDaftar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.keongpuyeng.app.kms.app.model.Pendaftaran[ idDaftar=" + idDaftar + " ]";
    }
    
}
