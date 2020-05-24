package com.locadoraveiculosweb.service;

import static com.locadoraveiculosweb.util.PasswordUtils.getDencryptedPass;

import java.io.Serializable;

import javax.inject.Inject;

import com.locadoraveiculosweb.dao.UsuarioDAO;
import com.locadoraveiculosweb.mappers.UsuarioMapper;
import com.locadoraveiculosweb.modelo.Usuario;
import com.locadoraveiculosweb.modelo.dtos.UsuarioDto;

public class UsuarioService implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	UsuarioDAO usuarioDao;
	
	@Inject
	UsuarioMapper mapper;
	
	public UsuarioDto login(String username, String password) {
		
		Usuario usuario = usuarioDao.findUsuarioByUsername(username, getEncryptPass(password));
		
		return mapper.toUsuarioDto(usuario);
	}
	
	private String getEncryptPass(String pass) {
		return getDencryptedPass(pass);
	}

}
