/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keongpuyeng.app.kms.app.service.serviceImplement;

import com.keongpuyeng.app.kms.app.model.SiswaDto;
import com.keongpuyeng.app.kms.app.service.IMailService;
import freemarker.template.Configuration;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.mail.internet.MimeMessage;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

/**
 *
 * @author Aldis-PC
 */
@Service
public class MailServiceImpl implements IMailService {

    private static final Logger log = Logger.getLogger(MailServiceImpl.class);

    @Autowired
    JavaMailSender mailSender;
    
    @Autowired
    Configuration freemarkerConfiguration;

    @Override
    public void sendMail(HashMap<String, Object> model, String emailAddress) {
//        SiswaDto siswa = (SiswaDto) object;
        MimeMessagePreparator preparator = getMessagePreparator(model, emailAddress);
        try {
            mailSender.send(preparator);
        } catch (MailException e) {
            log.error("ERROR DISINI ", e);
        }
    }

    private MimeMessagePreparator getMessagePreparator(HashMap<String, Object> model, String emailAddress) {
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

                helper.setSubject("Info Pendaftaran");
                helper.setFrom("KMS-Musik");
                helper.setTo(emailAddress);

//                Map<String, Object> model = new HashMap<>();
//                model.put("siswa", siswa);
                File file = new ClassPathResource("fmtemplates/logo.png").getFile();
        
//                String imageUrl = new ClassPathResource("Alsac.jpg").getPath();
                String imageUrl = file.getPath();
                System.out.println("IMAGE URL -> " + imageUrl);
                model.put("image", "https://i.ibb.co/vhT88Cb/logo.png");

                // just replace with velocity or freemarker
                String text = getFreeMarkerTemplate(model);
                log.info("TEMPLATE CONTENT : " + text);

                // multipart mime message adalah mengirim html dan text dalam sebuah pesan email
                helper.setText(text, true);

                // kirim attachment
                //helper.addAttachment("COKELAT-ENAK.jpg", new ClassPathResource("image/chocolatos.jpg"));
            }
        };
        return preparator;
    }
    
    private String getFreeMarkerTemplate(Map<String, Object> model){
        StringBuilder builder = new StringBuilder();
        try{
            builder.append(FreeMarkerTemplateUtils
                    .processTemplateIntoString(freemarkerConfiguration
                            .getTemplate("fm_mailTemplate.txt"), model));
            return builder.toString();
        }catch(Exception e){
            log.error("ERROR KETIKA PROSES FREEMARKER TEMPLATE", e);
        }
        return "";
    }
}
