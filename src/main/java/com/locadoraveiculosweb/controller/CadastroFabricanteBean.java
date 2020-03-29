package com.locadoraveiculosweb.controller;

import static com.locadoraveiculosweb.constants.MessageConstants.ViewMessages.FABRICANTE_SALVO_COM_SUCESSO;
import static com.locadoraveiculosweb.util.messages.MessageUtils.getMessage;

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
public class CadastroFabricanteBean extends BeanController<FabricanteDto> {

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
	protected String getSuccessMessage(FabricanteDto fabricante) {
		return getMessage(FABRICANTE_SALVO_COM_SUCESSO.getDescription(), fabricante.getNome());
	}
}
