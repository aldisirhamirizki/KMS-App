/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keongpuyeng.app.kms.app.service.serviceImplement;

import com.keongpuyeng.app.kms.app.dao.UserDao;
import com.keongpuyeng.app.kms.app.model.User;
import com.keongpuyeng.app.kms.app.service.IUserService;
import java.text.DecimalFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Aldis-PC
 */

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;
    
    @Override
    public List<User> getUsers() {
        return userDao.findAll();
    }

    @Override
    public void saveUser(User users) {
        users.setIdUser(automatedId());
        userDao.save(users);
    }

    @Override
    public User getUser(String id) {
        return userDao.getOne(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.save(user);
    }

    @Override
    public void deleteUser(String id) {
        userDao.deleteById(id);
    }

    private String automatedId() {
        List<User> listUser = userDao.findAll();
        
        String id = null;
        if (listUser.isEmpty()) {
            id = "U-01";
        }
        else {
            DecimalFormat formatId = new DecimalFormat("U-00");
            String nomorUrut = listUser.stream().reduce((first, second) -> second).orElse(null).getIdUser().substring(2);
            id=formatId.format(Double.parseDouble(nomorUrut)+1);
        }
        return id ;
    
    }
}
