package com.locadoraveiculosweb.controller;

import static com.locadoraveiculosweb.constants.ServiceConstants.MODELO_CARRO;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import com.locadoraveiculosweb.modelo.dtos.ModeloCarroDto;
import com.locadoraveiculosweb.service.ModeloCarroService;
import com.locadoraveiculosweb.service.Service;

import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class PesquisaModeloCarroBean extends BaseBeanController<ModeloCarroDto> {

	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	private List<ModeloCarroDto> modelosCarro;
	
	@Getter @Setter
	private ModeloCarroDto modeloCarroSelecionado;
	
	@Inject
	ModeloCarroService modeloCarroService;
	
	@Override
	@PostConstruct
	public void initializer() {
		this.modelosCarro = this.modeloCarroService.buscarTodos();
	}

	@Override
	protected void clean() {
		modelosCarro.remove(modeloCarroSelecionado);
	}

	@Override
	protected Service<ModeloCarroDto> getService() {
		return modeloCarroService;
	}

	@Override
	protected ModeloCarroDto getViewObject() {
		return modeloCarroSelecionado;
	}

	@Override
	protected String getNameMessage() {
		return MODELO_CARRO;
	}

	@Override
	protected String getViewObjectPropertyMsg() {
		return modeloCarroSelecionado.getDescricao();
	}

	@Override
	protected void setViewObject(ModeloCarroDto dto) {
		setModeloCarroSelecionado(dto);
	}
}
