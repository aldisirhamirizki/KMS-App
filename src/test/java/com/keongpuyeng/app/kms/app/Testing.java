/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keongpuyeng.app.kms.app;

import com.google.gson.Gson;
import com.keongpuyeng.app.kms.app.configuration.AppConfig;
import com.keongpuyeng.app.kms.app.controller.UserController;
import com.keongpuyeng.app.kms.app.dao.ProgramDao;
import com.keongpuyeng.app.kms.app.dao.SiswaDao;
import com.keongpuyeng.app.kms.app.dao.UserDao;
import com.keongpuyeng.app.kms.app.model.*;
import com.keongpuyeng.app.kms.app.service.IGenerateReport;
import com.keongpuyeng.app.kms.app.service.IKonfirmasiService;
import com.keongpuyeng.app.kms.app.service.IMailService;
import com.keongpuyeng.app.kms.app.service.IPendaftaranService;
import com.keongpuyeng.app.kms.app.service.ISiswaService;
import com.keongpuyeng.app.kms.app.service.IUserService;
import java.io.File;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import org.apache.tika.Tika;
import org.joda.time.format.DateTimeFormat;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import javax.naming.ldap.PagedResultsControl;

/**
 *
 * @author Aldis-PC
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@WebAppConfiguration
public class Testing {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private IUserService userService;

    @Autowired
    private UserDao userDao;
    
    @Autowired
    private SiswaDao siswaDao;
    
    @Autowired
    private IPendaftaranService pendService;
    
    @Autowired
    private ProgramDao programDao;
    
    @Autowired
    private ISiswaService siswaService;
    
    @Autowired
    private IMailService mailService;
    
    @Autowired
    private IKonfirmasiService konfirmService;
    
    @Autowired
    private IGenerateReport report;
    
    private MockMvc mockMvc;

//    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
//    
    @Test
    @Transactional
    public void myTesting() throws Exception{

        Pageable page = PageRequest.of(2, 3);
        System.out.println("PAGE: " + page.getPageNumber());
        System.out.println("PAGE: " + page.getOffset());
        System.out.println("PAGE: " + page.getPageSize());
        System.out.println("PAGE: " + page.hasPrevious());
        System.out.println("PAGE: " + page.isPaged());
        System.out.println("PAGE: " + page.isUnpaged());
        System.out.println("PAGE: " + page.toString());

//        List<Object> search2 = Arrays.asList(siswaDao.searchTemp(""));
        Page<Object> search = siswaDao.searchTempWithPage("", page);
        System.out.println("SEARCH TOTAL ELEMENTS: " + search.getTotalElements());
        System.out.println("SEARCH TOTAL PAGES: " + search.getTotalPages());
        System.out.println("SEARCH NUMBER (HALAMAN SAAT INI): " + search.getNumber());
        System.out.println("SEARCH NUMBER OF ELEMENTS (JUMLAH ELEMENT DI HALAMAN): " + search.getNumberOfElements());
        System.out.println("SEARCH CONTENT SIZE: " + search.getContent().size());
        System.out.println("SEARCH IS FIRST: " + search.isFirst());
        System.out.println("SEARCH IS LAST: " + search.isLast());
        System.out.println("SEARCH HAS CONTENT: " + search.hasContent());
        System.out.println("SEARCH HAS NEXT: " + search.hasNext());
        System.out.println("SEARCH HAS PREVIOUS: " + search.hasPrevious());


//        List<Object> objects = ;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<SiswaDto> listSiswaDto = new ArrayList<>();
        for (Object object : search.get().collect(Collectors.toList())) {
            Object[] obj = (Object[]) object;
            SiswaDto siswaDto = new SiswaDto();

            siswaDto.setIdSiswa(obj[0].toString());
            siswaDto.setNamaDaftar(obj[1].toString());
            siswaDto.setJenisKelamin(obj[2].toString());
            try {
                siswaDto.setTanggalLahir(sdf.parse(obj[3].toString()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            siswaDto.setTempatTinggal(obj[4].toString());
            siswaDto.setTelepon(obj[5].toString());
            siswaDto.setIdProgram(obj[6].toString());
            siswaDto.setIdKursus(obj[7].toString());
            siswaDto.setIdLevel(obj[8].toString());
            siswaDto.setStatus(obj[9] == null ? "" : obj[9].toString());

            listSiswaDto.add(siswaDto);
        }
        listSiswaDto.stream().forEach(p -> {
            System.out.println("OBJECT: " + new Gson().toJson(p));
        });

    }
}
