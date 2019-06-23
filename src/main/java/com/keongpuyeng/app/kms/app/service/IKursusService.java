/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keongpuyeng.app.kms.app.service;

import com.keongpuyeng.app.kms.app.model.Kursus;
import java.util.List;

/**
 *
 * @author Aldis-PC
 */
public interface IKursusService {
    
    public List<Kursus> getListKursus();
    
    public void saveKursus(Kursus kursus);
    
    public Kursus getKursus(String id);
    
    public void updateKursus(Kursus kursus);
    
    public void deleteKursus(String id);
}
