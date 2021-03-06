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
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Aldis-PC
 */

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;
    
    @Override
    @Transactional
    public List<User> getUsers() {
        return userDao.findAll();
    }

    @Override
    @Transactional
    public void saveUser(User users) {
        users.setIdUser(automatedId());
        userDao.save(users);
    }

    @Override
    @Transactional
    public User getUser(String id) {
        System.out.println("String ID: " + id);
        // ganti method jadi findById()
//        return userDao.getOne;
        return userDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(String id) {
        userDao.deleteById(id);
    }
    
    @Override
    public User getLogin(User user) {
        User p = userDao.adminLogin(user.getEmailUser(), user.getPasswordUser());
        return p;
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
