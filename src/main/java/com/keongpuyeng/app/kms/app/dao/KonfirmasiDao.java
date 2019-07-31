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
public interface KonfirmasiDao extends JpaRepository<KonfirmasiPembayaran, Object> {

    @Query(value = "SELECT * FROM konfirmasi_pembayaran kp WHERE kp.id_siswa = :paramSiswa",
            nativeQuery = true)
    KonfirmasiPembayaran findKonfirmasiPembayaranByIdSiswa(@Param("paramSiswa") String idSiswa);

    @Query(value = "SELECT kp.id_konfirmasi, kp.id_siswa, p.nama_daftar, kp.bank, b.nama_bank, kp.image_bukti, kp.status FROM konfirmasi_pembayaran kp \n"
            + "INNER JOIN siswa s ON kp.id_siswa = s.id_siswa\n"
            + "INNER JOIN pendaftaran p ON s.id_daftar = p.id_daftar\n"
            + "INNER JOIN bank b ON kp.bank = b.id_bank\n"
            + "WHERE kp.id_siswa = :idSiswa ", nativeQuery = true)
    Object konfirmForm(@Param("idSiswa") String idSiswa);

    @Query(value = "SELECT kp.id_siswa, kp.id_konfirmasi, p.nama_daftar, kp.bank, kp.tgl_konfirmasi, kp.total_biaya FROM konfirmasi_pembayaran kp\n"
            + "LEFT JOIN siswa s ON kp.id_siswa = s.id_siswa\n"
            + "LEFT JOIN pendaftaran p ON s.id_daftar = p.id_daftar", nativeQuery = true)
    Object[] listKonfirmasiNama();

    @Query(value = "SELECT kp.id_siswa, kp.id_konfirmasi, p.nama_daftar, kp.bank, kp.tgl_konfirmasi, kp.total_biaya FROM konfirmasi_pembayaran kp\n"
            + "LEFT JOIN siswa s ON kp.id_siswa = s.id_siswa\n"
            + "LEFT JOIN pendaftaran p ON s.id_daftar = p.id_daftar\n"
            + "WHERE s.id_siswa LIKE CONCAT('%', :cari, '%') OR\n"
            + "kp.id_konfirmasi LIKE CONCAT('%', :cari, '%') OR\n"
            + "p.nama_daftar LIKE CONCAT('%', :cari, '%') OR\n"
            + "kp.tgl_konfirmasi LIKE CONCAT('%', :cari, '%')"
            + "ORDER BY s.id_siswa ASC", nativeQuery = true)
    Object searchKonfirm(@Param("cari") String cari);

}
