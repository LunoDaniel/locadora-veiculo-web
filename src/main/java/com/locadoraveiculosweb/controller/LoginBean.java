package com.locadoraveiculosweb.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter @Setter
	String userName;
	
	@Getter @Setter
	String password;
	
	public String login() {
        FacesMessage message = null;
         
        if(userName != null && userName.equals("admin") && password != null && password.equals("admin")) {
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", userName);
            
            FacesContext.getCurrentInstance().addMessage(null, message);
            return "/Home?faces-redirect=true";
        } else {
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Usuário ou Senha invárlidos");
            
            FacesContext.getCurrentInstance().addMessage(null, message);
            return null;
        }
        
    }   
}


