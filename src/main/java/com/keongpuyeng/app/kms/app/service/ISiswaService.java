/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keongpuyeng.app.kms.app.service;

import com.keongpuyeng.app.kms.app.model.Siswa;
import com.keongpuyeng.app.kms.app.model.SiswaDto;
import java.util.List;

/**
 *
 * @author Aldis-PC
 */
public interface ISiswaService {
    public List<Siswa> getListSiswa();
    
    public Siswa saveSiswa(Siswa siswa);
    
    public Siswa getSiswa(String id);
    
    public Siswa getSiswaByIdDaftar(String idDaftar);
    
    public void updateSiswa(Siswa siswa);
    
    public void deleteSiswa(String id);
}
