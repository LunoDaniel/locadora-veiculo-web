package com.locadoraveiculosweb.controller;

import static com.locadoraveiculosweb.constants.MessageConstants.ViewMessages.ACESSORIO_SALVO_COM_SUCESSO;
import static com.locadoraveiculosweb.util.messages.MessageUtils.getMessage;

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
public class CadastroAcessorioBean extends BeanController<AcessorioDto> {
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
	protected String getSuccessMessage(AcessorioDto object) {
		return getMessage(ACESSORIO_SALVO_COM_SUCESSO.getDescription(), object.getDescricao());
	}
	
}
