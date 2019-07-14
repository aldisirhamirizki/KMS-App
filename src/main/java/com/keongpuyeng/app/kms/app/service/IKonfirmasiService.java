/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keongpuyeng.app.kms.app.service;

import com.keongpuyeng.app.kms.app.model.KonfirmasiPembayaran;
import java.util.List;

/**
 *
 * @author Aldis-PC
 */
public interface IKonfirmasiService {
    public List<KonfirmasiPembayaran> getListKonfirmasi();
    
    public void saveKonfirmasi(KonfirmasiPembayaran konfirmasi);
    
    public KonfirmasiPembayaran getKonfirmasi(String id);
    
    public KonfirmasiPembayaran getKonfirmasiByIdSiswa(String id);
    
    public void updateKonfirmasi(KonfirmasiPembayaran konfirmasi);
    
    public void deleteKonfirmasi(String id);
}
