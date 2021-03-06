package com.locadoraveiculosweb.controller;

import static com.locadoraveiculosweb.constants.ServiceConstants.CARRO;
import static java.util.Arrays.asList;
import static org.apache.commons.lang3.ArrayUtils.isEmpty;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import com.locadoraveiculosweb.modelo.dtos.AcessorioDto;
import com.locadoraveiculosweb.modelo.dtos.CarroDto;
import com.locadoraveiculosweb.service.AcessorioService;
import com.locadoraveiculosweb.service.CarroService;
import com.locadoraveiculosweb.service.Service;

import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class PesquisaCarroBean extends BaseBeanController<CarroDto> { 
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CarroService carroService;
	
	@Inject
	private AcessorioService acessorioService;
	
	@Getter @Setter
	private List<CarroDto> carros;
	
	@Getter @Setter
	private List<AcessorioDto> acessorios;
	
	@Getter @Setter
	private AcessorioDto[] arrAcessorios;
	
	@Getter
	private List<AcessorioDto> acessoriosList;
	
	@Getter @Setter
	private CarroDto carroSelecionado;

	@Override
	@PostConstruct
	public void initializer() {
		this.carros = carroService.buscarTodos();
		this.acessorios = acessorioService.buscarTodos();
	}

	@Override
	protected void clean() {
		carros.remove(carroSelecionado);
	}

	@Override
	protected Service<CarroDto> getService() {
		return carroService;
	}


	@Override
	protected CarroDto getViewObject() {
		return carroSelecionado;
	}

	@Override
	protected String getNameMessage() {
		return CARRO;
	}

	@Override
	protected String getViewObjectPropertyMsg() {
		return carroSelecionado.getChassi();
	}

	@Override
	protected void setViewObject(CarroDto dto) {
		setCarroSelecionado(dto);
	}
	
	public boolean isAcessoriosEmpty(CarroDto carro) {
		return isEmpty(carro.getAcessorios());
	}
	
	public void setCarroComAcessorios(CarroDto carro) {
		arrAcessorios = carro.getAcessorios();
	}
	
	public void setAcessoriosList(CarroDto carro) {
		this.acessoriosList = new ArrayList<>();
		acessoriosList.addAll(asList(carro.getAcessorios()));
	}

}
