package com.locadoraveiculosweb.service;

import static org.apache.commons.lang3.ObjectUtils.isEmpty;

import java.io.Serializable;

import javax.inject.Inject;

import com.locadoraveiculosweb.dao.SegurancaUsuarioDAO;
import com.locadoraveiculosweb.exception.SegurancaException;
import com.locadoraveiculosweb.modelo.SegurancaUsuario;
import com.locadoraveiculosweb.modelo.Usuario;
import com.locadoraveiculosweb.service.security.PasswordManager;

public class SegurancaUsuarioService  implements Serializable {

	private static final long serialVersionUID = 1L;
	

	@Inject
	SegurancaUsuarioDAO segurancaUsuarioDao;
	
	PasswordManager passwordManager;
	
	SegurancaUsuarioService() {
		passwordManager = new PasswordManager();
	}
	
	
	protected boolean hasCredenciaisUsuario(Usuario usuario, String password) throws SegurancaException {
		SegurancaUsuario segurancaUsuario = segurancaUsuarioDao.buscarPeloCodigoUsuario(usuario.getCodigo());
		String pass = passwordManager.getDencryptedPass(password, segurancaUsuario.getPrivateKeyUsuario());
		
		
		return !isEmpty(segurancaUsuario) || password.equalsIgnoreCase(pass);
		
	}

}
