/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keongpuyeng.app.kms.app.dao;

import com.keongpuyeng.app.kms.app.model.KonfirmasiPembayaran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Aldis-PC
 */

@Repository
public interface KonfirmasiDao extends JpaRepository<KonfirmasiPembayaran, Object>{
    
    @Query(value = "SELECT * FROM konfirmasi_pembayaran kp WHERE kp.id_siswa = :paramSiswa", 
            nativeQuery = true)
    KonfirmasiPembayaran findKonfirmasiPembayaranByIdSiswa(@Param("paramSiswa") String idSiswa);
}
