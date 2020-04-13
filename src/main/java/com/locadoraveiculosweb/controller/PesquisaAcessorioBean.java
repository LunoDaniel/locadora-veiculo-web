package com.locadoraveiculosweb.controller;

import static com.locadoraveiculosweb.constants.MessageConstants.ViewMessages.ACESSORIO_EXCLUIDO_COM_SUCESSO;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import com.locadoraveiculosweb.modelo.dtos.AcessorioDto;
import com.locadoraveiculosweb.service.AcessorioService;
import com.locadoraveiculosweb.service.Service;
import com.locadoraveiculosweb.util.messages.MessageUtils;

import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class PesquisaAcessorioBean extends BaseController<AcessorioDto> {
	
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
		acessorios.remove(acessorioSelecionado);		
	}

	@Override
	protected Service<AcessorioDto> getService() {
		return acessorioService;
	}

	@Override
	protected AcessorioDto getViewObject() {
		return acessorioSelecionado;
	}

	@Override
	protected String getSuccessMessage(AcessorioDto object) {
		return MessageUtils.getMessage(ACESSORIO_EXCLUIDO_COM_SUCESSO.getDescription(), object);
	}
	
}
