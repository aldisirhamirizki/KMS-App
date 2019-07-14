/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keongpuyeng.app.kms.app.service.serviceImplement;

import com.keongpuyeng.app.kms.app.dao.SiswaDao;
import com.keongpuyeng.app.kms.app.service.ISiswaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.keongpuyeng.app.kms.app.model.Siswa;
import com.keongpuyeng.app.kms.app.model.SiswaDto;
import java.text.DecimalFormat;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Aldis-PC
 */

@Service
public class SiswaServiceImplement implements ISiswaService{
    
    @Autowired
    private SiswaDao siswaDao;
    
    @Override
    @Transactional
    public List<Siswa> getListSiswa() {
        return siswaDao.findAll();
    }

    @Override
    @Transactional
    public Siswa saveSiswa(Siswa siswa) {
        siswa.setIdSiswa(sisId());
        siswaDao.save(siswa);
        return siswa;
    }
    @Override
    @Transactional
    public Siswa getSiswa(String id) {
        return siswaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Siswa getSiswaByIdDaftar(String idDaftar) {
        System.out.println("ID DAFTAR: " + idDaftar);
        return siswaDao.findByIdDaftar(idDaftar);
    }
    
    

    @Override
    @Transactional
    public void updateSiswa(Siswa siswa) {
        siswaDao.save(siswa);
    }

    @Override
    @Transactional
    public void deleteSiswa(String id) {
        siswaDao.deleteById(id);
    }
    
    private String sisId() {
        List<Siswa> listSiswa = siswaDao.findAll();
        
        String id = null;
        if (listSiswa.isEmpty()) {
            id = "S-0001";
        }
        else {
            DecimalFormat formatId = new DecimalFormat("S-0000");
            String nomorUrut = listSiswa.stream().reduce((first, second) -> second).orElse(null).getIdSiswa().substring(4);
            id=formatId.format(Double.parseDouble(nomorUrut)+1);
        }
        return id ;
    
    }
    
}