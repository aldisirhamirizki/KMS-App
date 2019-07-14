/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keongpuyeng.app.kms.app.dao;

import com.keongpuyeng.app.kms.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Aldis-PC
 */
@Repository
public interface UserDao extends JpaRepository<User, String>{
    
    @Query(value = "SELECT * FROM user WHERE email_user = :email"
    + " AND password_user = :password", nativeQuery = true)
    User adminLogin(@Param("email") String email, @Param("password") String password);
}
