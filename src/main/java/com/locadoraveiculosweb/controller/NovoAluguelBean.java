package com.locadoraveiculosweb.controller;

import static com.locadoraveiculosweb.constants.ServiceConstants.ALUGUEL;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import com.locadoraveiculosweb.modelo.dtos.AluguelDto;
import com.locadoraveiculosweb.modelo.dtos.ApoliceSeguroDto;
import com.locadoraveiculosweb.modelo.dtos.CarroDto;
import com.locadoraveiculosweb.service.AluguelService;
import com.locadoraveiculosweb.service.CarroService;
import com.locadoraveiculosweb.service.Service;

import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class NovoAluguelBean extends BaseBeanController<AluguelDto> {
	private static final long serialVersionUID = 1L;

	@Inject
	private AluguelService cadastroAluguelService;

	@Inject
	private CarroService carroService;

	@Getter
	@Setter
	private AluguelDto aluguel;

	@Getter
	@Setter
	private List<CarroDto> carros;

	@Override
	@PostConstruct
	public void initializer() {
		clean();
		this.carros = this.carroService.buscarTodos();
	}

	public void clean() {
		aluguel = new AluguelDto();
		this.aluguel.setApoliceSeguro(new ApoliceSeguroDto());
	}

	@Override
	protected Service<AluguelDto> getService() {
		return cadastroAluguelService;
	}

	@Override
	protected AluguelDto getViewObject() {
		return aluguel;
	}

	@Override
	protected void setViewObject(AluguelDto dto) {
		aluguel = dto;
	}

	@Override
	protected String getNameMessage() {
		return ALUGUEL;
	}

	@Override
	protected String getViewObjectPropertyMsg() {
		return aluguel.getCarro().getChassi();
	}

}
