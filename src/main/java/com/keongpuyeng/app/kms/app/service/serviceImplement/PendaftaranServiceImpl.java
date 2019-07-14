/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keongpuyeng.app.kms.app.service.serviceImplement;

import com.google.gson.Gson;
import com.keongpuyeng.app.kms.app.dao.PendaftaranDao;
import com.keongpuyeng.app.kms.app.model.Pendaftaran;
import com.keongpuyeng.app.kms.app.service.IPendaftaranService;
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
public class PendaftaranServiceImpl implements IPendaftaranService{
    
    @Autowired
    private PendaftaranDao pendaftaranDao;

    @Override
    @Transactional
    public List<Pendaftaran> getListPendaftaran() {
        return pendaftaranDao.findAll();
    }

    @Override
    @Transactional
    public boolean savePendaftaran(Pendaftaran pendaftaran) {
        pendaftaran.setIdDaftar(pendId());
        Pendaftaran p = pendaftaranDao.save(pendaftaran);
        if ( pendaftaran.getIdDaftar().equalsIgnoreCase(p.getIdDaftar()) )return true;
        System.out.println("Pendaftaran Id: " + new Gson().toJson(p));
        return false;
    }

    @Override
    @Transactional
    public Pendaftaran getPendaftaran(String id) {
         return pendaftaranDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void updatePendaftaran(Pendaftaran pendaftaran) {
        pendaftaranDao.save(pendaftaran);
    }

    @Override
    @Transactional
    public void deletePendaftaran(String id) {
        pendaftaranDao.deleteById(id);
    }

    @Override
    public Pendaftaran getLogin(Pendaftaran pendaftaran) {
        Pendaftaran p = pendaftaranDao.doLogin(pendaftaran.getEmailDaftar(), pendaftaran.getPasswordDaftar());
        return p;
    }
    
    private String pendId() {
        List<Pendaftaran> listPendaftaran = pendaftaranDao.findAll();
        String id = null;
        if (listPendaftaran.isEmpty()) {
            id = "D-0001";
        }
        else {
            DecimalFormat formatId = new DecimalFormat("D-0000");
            String nomorUrut = listPendaftaran.stream().reduce((first, second) -> second).orElse(null).getIdDaftar().substring(5);
            id=formatId.format(Double.parseDouble(nomorUrut)+1);
        }
        return id ;
    
    } 
    
}
