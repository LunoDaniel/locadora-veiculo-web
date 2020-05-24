package com.locadoraveiculosweb.util.jsf;

import static javax.faces.context.FacesContext.getCurrentInstance;

import javax.faces.application.FacesMessage;

public class FacesUtil {
	
	FacesUtil() {}
	
	public static void addSuccessMessage(String message) {
		getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						message, message)); 
	}
	
	public static void addErrorMessage(String message) {
		getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_ERROR,
						message, message)); 
	}
	
}