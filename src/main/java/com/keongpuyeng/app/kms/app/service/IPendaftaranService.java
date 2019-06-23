/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keongpuyeng.app.kms.app.service;

import com.keongpuyeng.app.kms.app.model.Pendaftaran;
import java.util.List;

/**
 *
 * @author Aldis-PC
 */
public interface IPendaftaranService {

    public List<Pendaftaran> getListPendaftaran();

    public void savePendaftaran(Pendaftaran pendaftaran);

    public Pendaftaran getPendaftaran(String id);

    public void updatePendaftaran(Pendaftaran pendaftaran);

    public void deletePendaftaran(String id);
}
