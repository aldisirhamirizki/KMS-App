/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keongpuyeng.app.kms.app.service.serviceImplement;

import com.keongpuyeng.app.kms.app.dao.KonfirmasiDao;
import com.keongpuyeng.app.kms.app.model.KonfirmasiPembayaran;
import com.keongpuyeng.app.kms.app.service.IKonfirmasiService;
import java.text.DecimalFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Aldis-PC
 */
@Service
public class KonfirmasiServiceImpl implements IKonfirmasiService {
    
    @Autowired
    private KonfirmasiDao konfirmasiDao;
    
     @Override
    @Transactional
    public List<KonfirmasiPembayaran> getListKonfirmasi() {
        List<KonfirmasiPembayaran> konfirmList = konfirmasiDao.findAll();
        return konfirmList;
    }

    @Override
    @Transactional
    public void saveKonfirmasi(KonfirmasiPembayaran konfirmasi) {
        konfirmasi.setIdKonfirmasi(kursId());
        konfirmasiDao.save(konfirmasi);
    }

    @Override
    @Transactional
    public KonfirmasiPembayaran getKonfirmasi(String id) {
         return konfirmasiDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public KonfirmasiPembayaran getKonfirmasiByIdSiswa(String id) {
        return konfirmasiDao.findKonfirmasiPembayaranByIdSiswa(id);
    }
    
    @Override
    @Transactional
    public void updateKonfirmasi(KonfirmasiPembayaran konfirmasi) {
        konfirmasiDao.save(konfirmasi);
    }

    @Override
    @Transactional
    public void deleteKonfirmasi(String id) {
        konfirmasiDao.deleteById(id);
    }

    private String kursId() {
        List<KonfirmasiPembayaran> listKonfirmasi = konfirmasiDao.findAll();

        String id = null;
        if (listKonfirmasi.isEmpty()) {
            id = "KP-0001";
        } else {
            DecimalFormat formatId = new DecimalFormat("KP-0000");
            String nomorUrut = listKonfirmasi.stream().reduce((first, second) -> second).orElse(null).getIdKonfirmasi().substring(4);
            id = formatId.format(Double.parseDouble(nomorUrut) + 1);
        }
        return id;
    }
}
