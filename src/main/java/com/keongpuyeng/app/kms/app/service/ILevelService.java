/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keongpuyeng.app.kms.app.service;

import com.keongpuyeng.app.kms.app.model.Level;
import java.util.List;

/**
 *
 * @author Aldis-PC
 */
public interface ILevelService {
    
    public List<Level> getListLevel();
    
    public void saveLevel(Level level);
    
    public Level getLevel(String id);
    
    public void updateLevel(Level level);
    
    public void deleteLevel(String id);
}
