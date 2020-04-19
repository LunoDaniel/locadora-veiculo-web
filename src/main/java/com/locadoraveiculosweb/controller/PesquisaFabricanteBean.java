package com.locadoraveiculosweb.controller;

import static com.locadoraveiculosweb.constants.ServiceConstants.FABRICANTE;

import java.util.ArrayList;
import java.util.List;

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
public class PesquisaFabricanteBean  extends BaseBeanController<FabricanteDto> {


	private static final long serialVersionUID = 1L;

	@Inject
	FabricanteService fabricanteService;
	
	@Getter @Setter
	private List<FabricanteDto> fabricantes = new ArrayList<>();
	
	@Getter @Setter
	private FabricanteDto fabricanteSelecionado;
	

	@Override
	@PostConstruct
	public void initializer() {
		fabricantes = buscarTodos();
	}

	@Override
	protected Service<FabricanteDto> getService() {
		return fabricanteService;
	}

	@Override
	protected void clean() {
		fabricantes.remove(fabricanteSelecionado);
	}

	@Override
	protected FabricanteDto getViewObject() {
		return fabricanteSelecionado;
	}

	@Override
	protected String getNameMessage() {
		return FABRICANTE;
	}

	@Override
	protected String getViewObjectPropertyMsg() {
		return fabricanteSelecionado.getNome();
	}

	@Override
	protected void setViewObject(FabricanteDto dto) {
		setFabricanteSelecionado(dto);
	}
}