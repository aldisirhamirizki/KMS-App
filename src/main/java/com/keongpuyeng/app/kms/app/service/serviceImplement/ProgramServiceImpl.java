/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keongpuyeng.app.kms.app.service.serviceImplement;

import com.google.gson.Gson;
import com.keongpuyeng.app.kms.app.dao.ProgramDao;
import com.keongpuyeng.app.kms.app.model.Program;
import com.keongpuyeng.app.kms.app.model.ProgramDto;
import com.keongpuyeng.app.kms.app.service.IProgramService;
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
public class ProgramServiceImpl implements IProgramService{

    @Autowired
    private ProgramDao programDao;
    
    @Override
    @Transactional
    public List<Program> getListPrograms() {
        List<Program> pList = programDao.findAll();        
        return pList;
    }

    @Override
    @Transactional
    public void saveProgram(Program program) {
        program.setIdProgram(progId());
        programDao.save(program);
    }

    @Override
    @Transactional
    public Program getProgram(String id) {
        return programDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void updateProgram(Program program) {
        programDao.save(program);
    }

    @Override
    @Transactional
    public void deleteProgram(String id) {
        programDao.deleteById(id);
    }
    
    private String progId() {
        List<Program> listProgram = programDao.findAll();
        
        String id = null;
        if (listProgram.isEmpty()) {
            id = "P-01";
        }
        else {
            DecimalFormat formatId = new DecimalFormat("P-00");
            String nomorUrut = listProgram.stream().reduce((first, second) -> second).orElse(null).getIdProgram().substring(2);
            id=formatId.format(Double.parseDouble(nomorUrut)+1);
        }
        return id ;
    
    }
    
}
