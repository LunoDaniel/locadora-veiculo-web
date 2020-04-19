package com.locadoraveiculosweb.controller;

import static com.locadoraveiculosweb.constants.ServiceConstants.CARRO;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import com.locadoraveiculosweb.modelo.dtos.AcessorioDto;
import com.locadoraveiculosweb.modelo.dtos.CarroDto;
import com.locadoraveiculosweb.modelo.dtos.ModeloCarroDto;
import com.locadoraveiculosweb.service.AcessorioService;
import com.locadoraveiculosweb.service.CarroService;
import com.locadoraveiculosweb.service.ModeloCarroService;
import com.locadoraveiculosweb.service.Service;

import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class CadastroCarroBean extends BaseBeanController<CarroDto>{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CarroService cadastroCarroService;
	
	@Inject
	private ModeloCarroService modeloCarroService;
	
	@Inject
	private AcessorioService acessorioService;
	
	@Getter @Setter
	private List<ModeloCarroDto> modelosCarros;
	
	@Getter @Setter
	private List<AcessorioDto> acessorios;
	
	@Getter @Setter
	private CarroDto carro;
	

	@PostConstruct
	@Override
	public void initializer() {
		clean();
		modelosCarros = modeloCarroService.buscarTodos();
		acessorios = acessorioService.buscarTodos();
	}

	@Override
	protected void clean() {
		this.carro = new CarroDto();
	}

	@Override
	protected Service<CarroDto> getService() {
		return cadastroCarroService;
	}

	@Override
	protected CarroDto getViewObject() {
		return carro;
	}

	@Override
	protected String getNameMessage() {
		return CARRO;
	}

	@Override
	protected String getViewObjectPropertyMsg() {
		return carro.getChassi();
	}

	@Override
	protected void setViewObject(CarroDto dto) {
		setCarro(dto);
	}
}
