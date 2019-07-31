/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keongpuyeng.app.kms.app.service.serviceImplement;

import com.keongpuyeng.app.kms.app.dao.KursusDao;
import com.keongpuyeng.app.kms.app.model.Kursus;
import com.keongpuyeng.app.kms.app.service.IKursusService;
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
public class KursusServiceImpl implements IKursusService {

    @Autowired
    private KursusDao kursusDao;

    @Override
    //@Transactional
    public List<Kursus> getListKursus() {
        List<Kursus> kList = kursusDao.findAll();
        return kList;
    }

    @Override
    @Transactional
    public void saveKursus(Kursus kursus) {
        kursus.setIdKursus(kursId());
        kursusDao.save(kursus);
    }

    @Override
    @Transactional
    public Kursus getKursus(String id) {
         return kursusDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void updateKursus(Kursus kursus) {
        kursusDao.save(kursus);
    }

    @Override
    @Transactional
    public void deleteKursus(String id) {
        kursusDao.deleteById(id);
    }

    private String kursId() {
        List<Kursus> listKursus = kursusDao.findAll();

        String id = null;
        if (listKursus.isEmpty()) {
            id = "K-01";
        } else {
            DecimalFormat formatId = new DecimalFormat("K-00");
            String nomorUrut = listKursus.stream().reduce((first, second) -> second).orElse(null).getIdKursus().substring(2);
            id = formatId.format(Double.parseDouble(nomorUrut) + 1);
        }
        return id;
    }
}
