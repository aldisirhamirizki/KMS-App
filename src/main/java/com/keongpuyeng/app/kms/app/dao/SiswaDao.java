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
public interface SiswaDao extends JpaRepository<Siswa, String> {

    @Query(value = "SELECT * FROM siswa s WHERE s.id_Daftar = :idDaftar",
            nativeQuery = true)
    Siswa findByIdDaftar(@Param("idDaftar") String idDaftar);

    @Query(value = "SELECT s.image FROM siswa s WHERE s.id_siswa = :idSiswa", nativeQuery = true)
    byte[] getImageSiswa(@Param("idSiswa") String idSiswa);

    @Query(value = "SELECT s.id_siswa, p.nama_daftar, s.jenis_kelamin, s.tanggal_lahir, s.tempat_tinggal, s.telepon, pm.nama_program, k.nama_kursus, l.nama_level, kp.status\n"
            + "FROM siswa s \n"
            + "LEFT JOIN pendaftaran p ON s.id_daftar = p.id_daftar \n"
            + "LEFT JOIN konfirmasi_pembayaran kp ON s.id_siswa = kp.id_siswa\n"
            + "INNER JOIN program pm ON s.id_program = pm.id_program\n"
            + "INNER JOIN kursus k ON s.id_kursus = k.id_kursus\n"
            + "INNER JOIN level l ON s.id_level = l.id_level\n"
            + "WHERE s.id_siswa LIKE CONCAT('%', :cari, '%') OR\n"
            + "p.nama_daftar LIKE CONCAT('%', :cari, '%') OR\n"
            + "kp.id_konfirmasi LIKE CONCAT('%', :cari, '%') OR\n"
            + "kp.status LIKE CONCAT('%', :cari, '%') OR\n"
            + "pm.nama_program LIKE CONCAT('%', :cari, '%') OR\n"
            + "k.nama_kursus LIKE CONCAT('%', :cari, '%') OR\n"
            + "l.nama_level LIKE CONCAT('%', :cari, '%') OR\n"
            + "s.jenis_kelamin LIKE CONCAT('%', :cari, '%')\n"
            + "ORDER BY s.id_siswa ASC", nativeQuery = true)
    Object[] searchTemp(@Param("cari") String cari);
    
    
    
}
