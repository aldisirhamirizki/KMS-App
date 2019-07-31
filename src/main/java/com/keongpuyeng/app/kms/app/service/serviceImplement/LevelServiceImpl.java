/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keongpuyeng.app.kms.app.service.serviceImplement;

import com.keongpuyeng.app.kms.app.dao.LevelDao;
import com.keongpuyeng.app.kms.app.model.Level;
import com.keongpuyeng.app.kms.app.service.ILevelService;
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
public class LevelServiceImpl implements ILevelService{
    
    @Autowired
    private LevelDao levelDao;
    
    @Override
    //@Transactional
    public List<Level> getListLevel() {
        List<Level> lList = levelDao.findAll(); 
        return lList;
    }

    @Override
    @Transactional
    public void saveLevel(Level level) {
       level.setIdLevel(bId());
       levelDao.save(level);
    }

    @Override
    @Transactional
    public Level getLevel(String id) {
        return levelDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void updateLevel(Level level) {
        levelDao.save(level);
    }

    @Override
    @Transactional
    public void deleteLevel(String id) {
        levelDao.deleteById(id);
    }
    
   private String bId() {
        List<Level> listLevel = levelDao.findAll();
        
        String id = null;
        if (listLevel.isEmpty()) {
            id = "L-01";
        }
        else {
            DecimalFormat formatId = new DecimalFormat("L-00");
            String nomorUrut = listLevel.stream().reduce((first, second) -> second).orElse(null).getIdLevel().substring(2);
            id=formatId.format(Double.parseDouble(nomorUrut)+1);
        }
        return id ;
    
    } 
    
}
