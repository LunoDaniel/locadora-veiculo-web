package com.locadoraveiculosweb.service;

import static com.locadoraveiculosweb.constants.MessageConstants.BusinessMessages.USUARIO_EXISTENTE;
import static com.locadoraveiculosweb.modelo.LoginStatusEnum.LOGIN_ERRO;
import static com.locadoraveiculosweb.modelo.LoginStatusEnum.LOGIN_SUCESSO;
import static com.locadoraveiculosweb.modelo.LoginStatusEnum.NOVO_LOGIN_ERRO;
import static com.locadoraveiculosweb.modelo.LoginStatusEnum.NOVO_LOGIN_SUCESSO;
import static com.locadoraveiculosweb.util.LoginEventsBuilder.create;
import static org.apache.commons.lang3.ObjectUtils.isEmpty;

import java.util.List;

import javax.inject.Inject;

import com.locadoraveiculosweb.dao.LoginEventsDAO;
import com.locadoraveiculosweb.exception.NegocioException;
import com.locadoraveiculosweb.exception.SegurancaException;
import com.locadoraveiculosweb.mappers.UsuarioMapper;
import com.locadoraveiculosweb.modelo.Usuario;
import com.locadoraveiculosweb.modelo.dtos.UsuarioDto;
import com.locadoraveiculosweb.util.jpa.Transactional;

public class UsuarioService extends SegurancaUsuarioService implements Service<UsuarioDto> {

	private static final long serialVersionUID = 1L;

	@Inject
	LoginEventsDAO loginEventsDao;

	@Inject
	UsuarioMapper mapper;

	public UsuarioDto login(String username, String password) throws SegurancaException {

		Usuario usuario = usuarioDao.findUsuarioByUsername(username);

		if (hasCredenciaisUsuario(usuario, password)) {
			loginEventsDao.salvar(create(username, LOGIN_SUCESSO));

			return mapper.toUsuarioDto(usuario);
		}

		loginEventsDao.salvar(create(username, LOGIN_ERRO));

		return null;

	}

	@Override
	@Transactional
	public UsuarioDto salvar(UsuarioDto dto) throws NegocioException {
		
		Usuario usuario = usuarioDao.findUsuarioByCpf(dto.getCpf());
		try {
			
			if(isEmpty(usuario)) {				
				usuario = salvarUsuario(mapper.toUsuario(dto));
				loginEventsDao.salvar(create(usuario.getEmail(), NOVO_LOGIN_SUCESSO));
				return mapper.toUsuarioDto(usuario);
			} else {				
				loginEventsDao.salvar(create(dto.getEmail(), NOVO_LOGIN_ERRO));
			}
			
			throw new NegocioException(USUARIO_EXISTENTE.getDescription());
		} catch (Exception e) {
			loginEventsDao.salvar(create(dto.getEmail(), NOVO_LOGIN_ERRO));
			throw new NegocioException("Erro ao salvar o usuário");
		}
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
