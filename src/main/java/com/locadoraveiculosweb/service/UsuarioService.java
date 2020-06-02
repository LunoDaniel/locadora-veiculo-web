package com.locadoraveiculosweb.service;

import static com.locadoraveiculosweb.util.LoginEventsBuilder.create;
import static com.locadoraveiculosweb.util.PasswordUtils.getEncryptedPass;
import static org.apache.commons.lang3.ObjectUtils.isEmpty;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.isBlank;

import java.io.Serializable;

import javax.inject.Inject;

import com.locadoraveiculosweb.dao.LoginEventsDAO;
import com.locadoraveiculosweb.dao.UsuarioDAO;
import com.locadoraveiculosweb.mappers.UsuarioMapper;
import com.locadoraveiculosweb.modelo.Usuario;
import com.locadoraveiculosweb.modelo.dtos.UsuarioDto;

public class UsuarioService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	UsuarioDAO usuarioDao;

	@Inject
	LoginEventsDAO loginEventsDao;

	@Inject
	UsuarioMapper mapper;

	public UsuarioDto login(String username, String password) {

		Usuario usuario = usuarioDao.findUsuarioByUsername(username, getEncryptPass(password));

		loginEventsDao.salvar(create(username, isEmpty(usuario)));

		return mapper.toUsuarioDto(usuario);
	}

	private String getEncryptPass(String pass) {
		if (isBlank(pass)) {
			return EMPTY;
		}
		return getEncryptedPass(pass);
	}

}
