package com.locadoraveiculosweb.controller;

import static com.locadoraveiculosweb.constants.MessageConstants.BusinessMessages.USUARIO_SENHA_INVALIDOS;
import static com.locadoraveiculosweb.constants.ServiceConstants.HOME_REDIRECT;
import static com.locadoraveiculosweb.util.SessionUtils.putOnSession;
import static com.locadoraveiculosweb.util.jsf.FacesUtil.addErrorMessage;
import static org.apache.commons.lang3.ObjectUtils.isEmpty;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.locadoraveiculosweb.exception.SegurancaException;
import com.locadoraveiculosweb.modelo.dtos.UsuarioDto;
import com.locadoraveiculosweb.service.UsuarioService;

import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	String username;

	@Getter
	@Setter
	String password;

	@Inject
	UsuarioService usuarioService;

	public String login() {

		UsuarioDto usuario;
		try {
			usuario = usuarioService.login(username, password);
			return (!isEmpty(usuario)) ? loginSuccess(usuario): loginError();
		} catch (SegurancaException e) {
			return loginError();
		}

	}
	
	private String loginError() {
		addErrorMessage(USUARIO_SENHA_INVALIDOS.getDescription());
		return null;
	}
	
	private String loginSuccess(UsuarioDto usuario) {
		putOnSession(usuario.getCpf());
		return HOME_REDIRECT;
	}
}
