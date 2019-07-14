/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keongpuyeng.app.kms.app.dao;

import com.keongpuyeng.app.kms.app.model.Program;
import com.keongpuyeng.app.kms.app.model.ProgramDto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Aldis-PC
 */

@Repository
public interface ProgramDao extends JpaRepository<Program, String>{
    
    @Query("SELECT NEW com.keongpuyeng.app.kms.app.model.ProgramDto(p.idProgram, p.namaProgram, p.biaya) FROM Program p")
    List<ProgramDto> myFindAllProgramDto();
}
