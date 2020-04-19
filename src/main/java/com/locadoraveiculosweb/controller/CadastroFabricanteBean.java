package com.locadoraveiculosweb.controller;

import static com.locadoraveiculosweb.constants.ServiceConstants.FABRICANTE;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import com.locadoraveiculosweb.modelo.dtos.FabricanteDto;
import com.locadoraveiculosweb.service.FabricanteService;
import com.locadoraveiculosweb.service.Service;

import lombok.Getter;
import lombok.Setter;


@Named
@ViewScoped
public class CadastroFabricanteBean extends BaseBeanController<FabricanteDto> {

	private static final long serialVersionUID = 1L;
	
	@Inject 
	private FabricanteService cadastroFabricanteSerivice;
	
	@Getter @Setter
	private FabricanteDto fabricante = new FabricanteDto();
	
	@Override
	@PostConstruct
	public void initializer(){
		clean();
	}

	@Override
	protected Service<FabricanteDto> getService() {
		return cadastroFabricanteSerivice;
	}

	@Override
	protected FabricanteDto getViewObject() {
		return fabricante;
	}

	@Override
	protected void clean() {
		fabricante = new FabricanteDto();
	}

	@Override
	protected String getNameMessage() {
		return FABRICANTE;
	}

	@Override
	protected String getViewObjectPropertyMsg() {
		return fabricante.getNome();
	}

	@Override
	protected void setViewObject(FabricanteDto dto) {
		setFabricante(dto);
	}
	
}
