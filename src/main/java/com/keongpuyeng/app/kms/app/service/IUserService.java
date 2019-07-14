/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keongpuyeng.app.kms.app.service;

import com.keongpuyeng.app.kms.app.model.User;
import java.util.List;

/**
 *
 * @author Aldis-PC
 */
public interface IUserService {
    
    public List<User> getUsers();
    
    public void saveUser(User Users);
    
    public User getUser(String id);
    
    public void updateUser(User user);
    
    public void deleteUser(String id);
    
     public User getLogin(User user);
    
}
