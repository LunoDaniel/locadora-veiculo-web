package com.locadoraveiculosweb.service;

import static com.locadoraveiculosweb.util.LoginEventsBuilder.create;
import static org.apache.commons.lang3.ObjectUtils.isEmpty;

import java.util.List;

import javax.inject.Inject;

import com.locadoraveiculosweb.dao.LoginEventsDAO;
import com.locadoraveiculosweb.dao.UsuarioDAO;
import com.locadoraveiculosweb.exception.NegocioException;
import com.locadoraveiculosweb.exception.SegurancaException;
import com.locadoraveiculosweb.mappers.UsuarioMapper;
import com.locadoraveiculosweb.modelo.Usuario;
import com.locadoraveiculosweb.modelo.dtos.UsuarioDto;

public class UsuarioService extends SegurancaUsuarioService implements Service<UsuarioDto> {

	private static final long serialVersionUID = 1L;

	@Inject
	UsuarioDAO usuarioDao;

	@Inject
	LoginEventsDAO loginEventsDao;
	

	@Inject
	UsuarioMapper mapper;

	public UsuarioDto login(String username, String password) throws SegurancaException {

		Usuario usuario = usuarioDao.findUsuarioByUsername(username);
	
		if(hasCredenciaisUsuario(usuario, password)) {
			loginEventsDao.salvar(create(username, isEmpty(usuario)));

			return mapper.toUsuarioDto(usuario);
		}
		
		return null;
	
	}

	@Override
	public UsuarioDto salvar(UsuarioDto object) throws NegocioException {
		return null;
	}

	@Override
	public UsuarioDto buscarPeloCodigo(String id) {
		return null;
	}

	@Override
	public void excluir(UsuarioDto viewObject) throws NegocioException {
		
	}

	@Override
	public List<UsuarioDto> buscarTodos() {
		return null;
	}
}
