/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keongpuyeng.app.kms.app.service.serviceImplement;

import com.google.gson.Gson;
import com.keongpuyeng.app.kms.app.dao.KonfirmasiDao;
import com.keongpuyeng.app.kms.app.model.KonfirmasiDto;
import com.keongpuyeng.app.kms.app.model.KonfirmasiPembayaran;
import com.keongpuyeng.app.kms.app.service.IKonfirmasiService;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

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
    //@Transactional
    public KonfirmasiPembayaran getKonfirmasi(String id) {
        return konfirmasiDao.findById(id).orElse(null);
    }

    @Override
//    @Transactional
    public KonfirmasiPembayaran getKonfirmasiByIdSiswa(String id) {
        return konfirmasiDao.findKonfirmasiPembayaranByIdSiswa(id);
    }

    @Override
    public KonfirmasiDto getKonfirmasiForm(String idSiswa) {
        Object[] objectKonfirm = (Object[]) konfirmasiDao.konfirmForm(idSiswa);
        KonfirmasiDto konfirmDto = new KonfirmasiDto();
        konfirmDto.setIdKonfirmasi(objectKonfirm[0].toString());
        konfirmDto.setIdSiswa(objectKonfirm[1].toString());
        konfirmDto.setNamaDaftar(objectKonfirm[2].toString());
        konfirmDto.setIdBank(objectKonfirm[3].toString());
        konfirmDto.setBank(objectKonfirm[4].toString());
        konfirmDto.setDisplayImageBukti((byte[]) objectKonfirm[5]);
        konfirmDto.setStatus(objectKonfirm[6].toString());

        System.out.println("DTO: " + new Gson().toJson(konfirmDto));

        // 1. butuh read dari byte[] ke File
        // 2. dari File baca contentType pakai library Apache Tika
        // 3. isi DiskFileItem
        // 4. isi CommonMultipartFile pakai DiskFileItem
        // name=family-fun-clipart-1.png, StoreLocation=E:\Pindah\App\apache-tomcat-8.5.37\work\Catalina\localhost\KMS-App\\upload_9e4849e1_5b6c_418f_9f37_ca4eed58a7c3_00000005.tmp, size=30674 bytes, isFormField=false, FieldName=imageBukti
        // FileItem fileItem = new DiskFileItem("file bukti", );
        return konfirmDto;
    }

    @Override
    public List<KonfirmasiDto> getListKonfirmasiNama() {
        List<Object> listKonfirmasiNama = Arrays.asList(konfirmasiDao.listKonfirmasiNama());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<KonfirmasiDto> listKonfirmasi = new ArrayList<>();

        for (Object object : listKonfirmasiNama) {
            Object[] obj = (Object[]) object;
            KonfirmasiDto konfirmDto = new KonfirmasiDto();

            konfirmDto.setIdSiswa(obj[0].toString());
            konfirmDto.setIdKonfirmasi(obj[1].toString());
            konfirmDto.setNamaDaftar(obj[2].toString());
            konfirmDto.setBank(obj[3].toString());
            try {
                konfirmDto.setTglKonfirmasi(sdf.parse(obj[4].toString()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            konfirmDto.setTotalBiaya(Double.parseDouble(obj[5].toString()));
        listKonfirmasi.add(konfirmDto);
        }
        return listKonfirmasi;
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
