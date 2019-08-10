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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.keongpuyeng.app.kms.app.model.Siswa;
import com.keongpuyeng.app.kms.app.model.SiswaDto;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Aldis-PC
 */
@Service
public class SiswaServiceImplement implements ISiswaService {

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
    public List<SiswaDto> getSearch(String cari) {
        List<Object> search = Arrays.asList(siswaDao.searchTemp(cari));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<SiswaDto> listSiswaDto = new ArrayList<>();

        for (Object object : search) {
            Object[] obj = (Object[]) object;
            SiswaDto siswaDto = new SiswaDto();

            siswaDto.setIdSiswa(obj[0].toString());
            siswaDto.setNamaDaftar(obj[1].toString());
            siswaDto.setJenisKelamin(obj[2].toString());
            try {
                siswaDto.setTanggalLahir(sdf.parse(obj[3].toString()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            siswaDto.setTempatTinggal(obj[4].toString());
            siswaDto.setTelepon(obj[5].toString());
            siswaDto.setIdProgram(obj[6].toString());
            siswaDto.setIdKursus(obj[7].toString());
            siswaDto.setIdLevel(obj[8].toString());
            siswaDto.setStatus(obj[9] == null ? "" : obj[9].toString());
            
            listSiswaDto.add(siswaDto);
        }
        return listSiswaDto;
    }

    @Override
    public byte[] getImageSiswa(String idSiswa) {
        return siswaDao.getImageSiswa(idSiswa);
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
        } else {
            DecimalFormat formatId = new DecimalFormat("S-0000");
            String nomorUrut = listSiswa.stream().reduce((first, second) -> second).orElse(null).getIdSiswa().substring(4);
            id = formatId.format(Double.parseDouble(nomorUrut) + 1);
        }
        return id;

    }

    @Override
    @Transactional
    public Page<Object> getSiswaPagination(String cari, Pageable page) {
        return siswaDao.searchTempWithPage(cari, page);
    }
}
