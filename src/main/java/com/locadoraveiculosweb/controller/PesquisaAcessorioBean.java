package com.locadoraveiculosweb.controller;

import static com.locadoraveiculosweb.constants.ServiceConstants.ACESSORIO;

import java.util.List;

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
public class PesquisaAcessorioBean extends BaseBeanController<AcessorioDto> {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private AcessorioService acessorioService;
	
	@Getter @Setter
	private AcessorioDto acessorioSelecionado;
	
	@Getter @Setter
	private List<AcessorioDto> acessorios;
	
	@Override
	@PostConstruct
	public void initializer(){
		this.acessorios = buscarTodos();
	}

	@Override
	protected void clean() {
		acessorios.remove(getViewObject());
	}

	@Override
	protected Service<AcessorioDto> getService() {
		return acessorioService;
	}

	@Override
	protected String getNameMessage() {
		return ACESSORIO;
	}

	@Override
	protected AcessorioDto getViewObject() {
		return acessorioSelecionado;
	}

	@Override
	protected String getViewObjectPropertyMsg() {
		return acessorioSelecionado.getDescricao();
	}

	@Override
	protected void setViewObject(AcessorioDto dto) {
		setAcessorioSelecionado(dto);
	}
}
