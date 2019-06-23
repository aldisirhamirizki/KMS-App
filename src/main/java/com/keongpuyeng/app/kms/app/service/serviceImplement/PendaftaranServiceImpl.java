/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keongpuyeng.app.kms.app.service.serviceImplement;

import com.keongpuyeng.app.kms.app.dao.PendaftaranDao;
import com.keongpuyeng.app.kms.app.model.Pendaftaran;
import com.keongpuyeng.app.kms.app.service.IPendaftaranService;
import java.text.DecimalFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Aldis-PC
 */
@Service
public class PendaftaranServiceImpl implements IPendaftaranService{
    
    @Autowired
    private PendaftaranDao pendaftaranDao;

    @Override
    public List<Pendaftaran> getListPendaftaran() {
        return pendaftaranDao.findAll();
    }

    @Override
    public void savePendaftaran(Pendaftaran pendaftaran) {
        pendaftaran.setIdSiswa(idSiswa());
        pendaftaranDao.save(pendaftaran);
    }

    @Override
    public Pendaftaran getPendaftaran(String id) {
        return pendaftaranDao.getOne(id);
    }

    @Override
    public void updatePendaftaran(Pendaftaran pendaftaran) {
        pendaftaranDao.save(pendaftaran);
    }

    @Override
    public void deletePendaftaran(String id) {
        pendaftaranDao.deleteById(id);
    }
    
    private String idSiswa() {
        List<Pendaftaran> listPendaftaran = pendaftaranDao.findAll();
        
        String id = null;
        if (listPendaftaran.isEmpty()) {
            id = "S-0001";
        }
        else {
            DecimalFormat formatId = new DecimalFormat("S-0000");
            String nomorUrut = listPendaftaran.stream().reduce((first, second) -> second).orElse(null).getIdSiswa().substring(5);
            id=formatId.format(Double.parseDouble(nomorUrut)+1);
        }
        return id ;
    
    } 
    
}
