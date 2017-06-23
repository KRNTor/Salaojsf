/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.felpz.salao.bean;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author wfeli
 */
@ManagedBean
public class NavBean {

    public void navAccount() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("../pages/account.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(NavBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void navGoogle() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("http://google.com");
        } catch (IOException ex) {
            Logger.getLogger(NavBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
