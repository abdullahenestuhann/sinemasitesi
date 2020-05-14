/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dao.�yeDAO;
import entity.�ye;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author ABDULLAH
 */
@Named
@SessionScoped
public class LoginController implements Serializable{
    private �yeDAO udao;
    private �ye uye;

    public String login(){
        uye = getUdao().girisYap(this.uye.getEmail(), this.uye.getSifre());
        if (this.uye != null) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_user", this.uye);
            return "/temp";
        }else{
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Hatalı kullanıcı adı veya şifre")  );
            return "/index";
        }       
    }

    public �yeDAO getUdao() {
        return udao == null ? udao = new �yeDAO() : udao;
    }

    public �ye getUye() {
        return uye == null ? uye = new �ye() : uye;
    }

    public void setUye(Üye uye) {
        this.uye = uye;
    }
    
 
}
