/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keongpuyeng.app.kms.app.model;

import java.util.List;

/**
 *
 * @author Aldis-PC
 */
public class ValidationResponse {
    private String status;
    private List<ErrorMessage> listErrorMessages;
    private String redirectUrl;

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ErrorMessage> getListErrorMessages() {
        return listErrorMessages;
    }

    public void setListErrorMessages(List<ErrorMessage> listErrorMessages) {
        this.listErrorMessages = listErrorMessages;
    }

    public ValidationResponse(String status, List<ErrorMessage> listErrorMessages) {
        this.status = status;
        this.listErrorMessages = listErrorMessages;
    }
    
    public ValidationResponse(){}
    
}
