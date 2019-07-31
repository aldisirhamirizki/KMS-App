/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keongpuyeng.app.kms.app.service.serviceImplement;

import com.keongpuyeng.app.kms.app.service.IGenerateReport;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRSaver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author Aldis-PC
 */
@Service
public class GenerateReportImpl implements IGenerateReport {

    @Autowired
    private DataSource datasource;

    private String reportFileName;
    private JasperReport jasperReport;
    private Map<String, Object> parameters = new HashMap<>();

    @Override
    public byte[] generatePdfReportSiswa(String cari) {
        byte[] pdf = null;
        try {
            // compile
            reportFileName = "reportSiswa.jrxml";
            Resource resource = new ClassPathResource("report/" + reportFileName);
            File file = resource.getFile();
            jasperReport = JasperCompileManager.compileReport(file.getPath());

            String jasperFile = file.getPath().replace(".jrxml", ".jasper");
            JRSaver.saveObject(jasperReport, jasperFile);

            Locale local = new Locale("id", "ID");

            String imgPath = getReportImgPath();

            parameters.put(JRParameter.REPORT_LOCALE, local);
            parameters.put("imgPath", imgPath);
            parameters.put("cari", cari);

            pdf = JasperRunManager.runReportToPdf(jasperFile, parameters, datasource.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pdf;
    }

    @Override
    public byte[] generatePdfReportKonfirmasi(String cari) {
        byte[] pdf = null;
        try {
            // compile
            reportFileName = "reportKonfirmasi.jrxml";
            Resource resource = new ClassPathResource("report/" + reportFileName);
            File file = resource.getFile();
            jasperReport = JasperCompileManager.compileReport(file.getPath());

            String jasperFile = file.getPath().replace(".jrxml", ".jasper");
            JRSaver.saveObject(jasperReport, jasperFile);

            String imgPath = getReportImgPath();

            Locale local = new Locale("id", "ID");
            parameters.put(JRParameter.REPORT_LOCALE, local);
            parameters.put("imgPath", imgPath);
            parameters.put("cari", cari);

            pdf = JasperRunManager.runReportToPdf(jasperFile, parameters, datasource.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pdf;
    }

    /**
     * get dynamic image path from resources package
     * @return
     * @throws Exception
     */
    public String getReportImgPath() throws Exception{
        // get dynamic image location path to jasper report
        Resource resource = new ClassPathResource("report/logo.png");
        String imgPath = resource.getFile().getPath();
        return imgPath;
    }

}
