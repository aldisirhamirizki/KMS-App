/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keongpuyeng.app.kms.app;

import com.google.gson.Gson;
import com.keongpuyeng.app.kms.app.configuration.AppConfig;
import com.keongpuyeng.app.kms.app.controller.UserController;
import com.keongpuyeng.app.kms.app.dao.UserDao;
import com.keongpuyeng.app.kms.app.model.Binatang;
import com.keongpuyeng.app.kms.app.model.User;
import com.keongpuyeng.app.kms.app.service.IUserService;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import javax.persistence.Basic;
import javax.servlet.ServletContext;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author Aldis-PC
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {AppConfig.class})
//@WebAppConfiguration
public class Testing {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private IUserService userService;

    @Autowired
    private UserDao userDao;
    
    private MockMvc mockMvc;

//    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

//    @Test
    public void myTesting() {
        ServletContext servletContext = wac.getServletContext();
//        List<User> listUser = userService.getUsers();
//        
//        String id = null;
//        if (listUser.isEmpty()) {
//            id = "U-01";
//        }
//        else {
//            DecimalFormat formatId = new DecimalFormat("U-00");
//            String nomorUrut = listUser.stream().reduce((first, second) -> second).orElse(null).getIdUser().substring(2);
//            id=formatId.format(Double.parseDouble(nomorUrut)+1);
//        }
        
//        User us = new User();
//        us.setIdUser(id);
//        us.setNamaUser("sss");
//        us.setEmailUser("wewewew");
//        us.setPasswordUser("qwqwqw");
//        
//        String json = new Gson().toJson(us);
//        
//        System.out.println(json);
//        
//        userService.saveUser(us);
//        System.out.println("sssssss" + getId );
            
            
            
            
            
            
            
//        ServletContext servletContext = wac.getServletContext();
//        Enumeration<String> list = servletContext.getAttributeNames();
//        List<String> listT = Collections.list(list);
//        
//        listT.forEach(p -> {
//            System.out.println("vvvvvvv" + p);
//        });
//        
//        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
////        scanner.addIncludeFilter(new AnnotationTypeFilter());
//        for (BeanDefinition beanDefinition : scanner.findCandidateComponents("com.keongpuyeng.app.kms.app.controller")){
//            System.out.println("Bean: " + beanDefinition.getBeanClassName());
//        }
//        
//        System.out.println();
        
        
        
//        System.out.println("Start testing...");
//
//        Binatang ayam = new Binatang("dua", "berkokok", "beras", "unggas");
//        System.out.println("--" + ayam.getKaki());
//        System.out.println(ayam.getSuara());
//        System.out.println(ayam.getMakanan());
//        System.out.println(ayam.getJenis());
//
//        Binatang sapi = new Binatang("empat", "mouu", "rumput", "mamalia");
//
//        List<Binatang> daftarBinatang = new ArrayList<>();
//        daftarBinatang.add(sapi);
//        daftarBinatang.add(ayam);
//
//        Binatang ayamClone = daftarBinatang.get(1);
//        System.out.println("apa ini" + daftarBinatang.get(1));
//
//        System.out.println("apaan sih " + daftarBinatang.size());
//
//        System.out.println(ayamClone.getKaki());
//        System.out.println(ayamClone.getSuara());
//        System.out.println(ayamClone.getMakanan());
//        System.out.println(ayamClone.getJenis());
//
//        Binatang binatang = null; 
//        
//        for (int i = 0; i < daftarBinatang.size(); i++) {
//            binatang = daftarBinatang.get(i);
//            System.out.println(binatang.getKaki());
//            System.out.println(binatang.getSuara());
//            System.out.println(binatang.getMakanan());
//            System.out.println(binatang.getJenis());
//        }
//
//        // create 10 user
//        List<User> users = userService.getUsers();
//        long usersCount = users.stream().count();
//        System.out.println("Users Count: " + usersCount);
//        int max = 10;
//        if (users.isEmpty()) {
//            int i = 0;
//            do {
//                User user = new User();
//                user.setIdUser("Id-" + String.valueOf(i));
//                user.setNamaUser("Android-" + String.valueOf(i));
//                user.setEmailUser("test.user" + String.valueOf(i) + "@gmail.com");
//                user.setPasswordUser(String.valueOf(i) + "abcd" + String.valueOf(i));
//                userService.saveUser(user);
//                i++;
//            } while (i < max);
//        } else {
//            User u = users.stream().reduce((first, second) -> second).orElse(null);
//            System.out.println("Id: " + u.getIdUser());
//            int lastIdNumber = Integer.parseInt(u.getIdUser().substring(3));
//            max = lastIdNumber + 10;
//            do {
//                User user = new User();
//                user.setIdUser("Id-" + String.valueOf(lastIdNumber));
//                user.setNamaUser("Android-" + String.valueOf(lastIdNumber));
//                user.setEmailUser("test.user" + String.valueOf(lastIdNumber) + "@gmail.com");
//                user.setPasswordUser(String.valueOf(lastIdNumber) + "abcd" + String.valueOf(lastIdNumber));
//                userService.saveUser(user);
//                lastIdNumber++;
//            } while (lastIdNumber < max);
//        }
//
//        users = userService.getUsers();
//        users.stream().forEach(p -> {
//            System.out.println(p.getIdUser());
//            System.out.println(p.getNamaUser());
//            System.out.println(p.getEmailUser());
//            System.out.println(p.getPasswordUser());
//            System.out.println("----------------------------");
//        });
    }
}
