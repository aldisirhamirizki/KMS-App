/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keongpuyeng.app.kms.app.service;

import com.keongpuyeng.app.kms.app.model.Program;
import java.util.List;

/**
 *
 * @author Aldis-PC
 */
public interface IProgramService {
    public List<Program> getListPrograms();
    
    public void saveProgram(Program program);
    
    public Program getProgram(String id);
    
    public void updateProgram(Program program);
    
    public void deleteProgram(String id);
}
