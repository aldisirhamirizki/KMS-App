/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keongpuyeng.app.kms.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.keongpuyeng.app.kms.app.model.Siswa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Aldis-PC
 */

@Repository
public interface SiswaDao extends JpaRepository<Siswa, String>{
    
    @Query(value = "SELECT * FROM siswa s WHERE s.id_Daftar = :idDaftar",
            nativeQuery = true)
    Siswa findByIdDaftar(@Param("idDaftar") String idDaftar);
}
