/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keongpuyeng.app.kms.app.service;

import java.util.HashMap;

/**
 *
 * @author Aldis-PC
 */
public interface IMailService {
    void sendMail(HashMap<String, Object> model, String emailAddress);
}
