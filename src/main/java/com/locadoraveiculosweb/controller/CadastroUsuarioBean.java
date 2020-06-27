package com.locadoraveiculosweb.controller;

import static com.locadoraveiculosweb.constants.ServiceConstants.USUARIO;
import static com.locadoraveiculosweb.util.SessionUtils.hasUser;
import static java.util.Arrays.asList;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import com.locadoraveiculosweb.modelo.Sexo;
import com.locadoraveiculosweb.modelo.dtos.FuncionarioDto;
import com.locadoraveiculosweb.modelo.dtos.MotoristaDto;
import com.locadoraveiculosweb.modelo.dtos.UsuarioDto;
import com.locadoraveiculosweb.service.Service;
import com.locadoraveiculosweb.service.UsuarioService;

import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class CadastroUsuarioBean extends BaseBeanController<UsuarioDto> {

	private static final long serialVersionUID = 1L;
	
	@Inject
	UsuarioService usuarioService; 

	@Getter @Setter
	List<Sexo> sexos;
	
	@Getter @Setter
	UsuarioDto usuario;

	@Override
	@PostConstruct
	public void initializer() {
		clean();
		sexos = asList(Sexo.values());
	}

	@Override
	protected void clean() {
		
		if(hasUser()) {
			usuario = new FuncionarioDto();
		}
		usuario = new MotoristaDto();
	}

	@Override
	protected Service<UsuarioDto> getService() {
		return usuarioService;
	}

	@Override
	protected UsuarioDto getViewObject() {
		return usuario;
	}

	@Override
	protected void setViewObject(UsuarioDto dto) {
		setUsuario(dto);
	}

	@Override
	protected String getNameMessage() {
		return USUARIO;
	}

	@Override
	protected String getViewObjectPropertyMsg() {
		return usuario.getNome();
	}

}
