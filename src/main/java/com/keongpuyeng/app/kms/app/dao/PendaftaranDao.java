/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keongpuyeng.app.kms.app.dao;

import com.keongpuyeng.app.kms.app.model.Pendaftaran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Aldis-PC
 */
@Repository
public interface PendaftaranDao extends JpaRepository<Pendaftaran, Object>{
    
    @Query(value = "SELECT * FROM pendaftaran WHERE email_daftar = :email "
            + "AND password_daftar = :password", nativeQuery = true)
    Pendaftaran doLogin(@Param("email") String email, @Param("password") String password);
}
