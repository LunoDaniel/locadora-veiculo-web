package com.locadoraveiculosweb.controller;

import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import com.locadoraveiculosweb.modelo.dtos.UsuarioDto;
import com.locadoraveiculosweb.service.Service;

@Named
@ViewScoped
public class CadastroUsuarioBean extends BaseBeanController<UsuarioDto> {

	private static final long serialVersionUID = 1L;

	@Override
	public void initializer() {
	}

	@Override
	protected void clean() {
	}

	@Override
	protected Service<UsuarioDto> getService() {
		return null;
	}

	@Override
	protected UsuarioDto getViewObject() {
		return null;
	}

	@Override
	protected void setViewObject(UsuarioDto dto) {
		
	}

	@Override
	protected String getNameMessage() {
		return null;
	}

	@Override
	protected String getViewObjectPropertyMsg() {
		return null;
	}

}
