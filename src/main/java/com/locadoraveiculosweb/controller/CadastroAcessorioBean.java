package com.locadoraveiculosweb.controller;

import static com.locadoraveiculosweb.constants.ServiceConstants.ACESSORIO;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import com.locadoraveiculosweb.modelo.dtos.AcessorioDto;
import com.locadoraveiculosweb.service.AcessorioService;
import com.locadoraveiculosweb.service.Service;

import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class CadastroAcessorioBean extends BaseBeanController<AcessorioDto> {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private AcessorioService cadastroAcessorioService;
	
	@Getter @Setter
	private AcessorioDto acessorio;

	@Override
	@PostConstruct
	public void initializer() {
		clean();
	}

	@Override
	protected void clean() {
		this.acessorio = new AcessorioDto();
	}

	@Override
	protected Service<AcessorioDto> getService() {
		return cadastroAcessorioService;
	}

	@Override
	protected AcessorioDto getViewObject() {
		return acessorio;
	}

	@Override
	protected String getNameMessage() {
		return ACESSORIO;
	}

	@Override
	protected String getViewObjectPropertyMsg() {
		return acessorio.getDescricao();
	}

	@Override
	protected void setViewObject(AcessorioDto dto) {
		setAcessorio(dto);
	}
	
}
