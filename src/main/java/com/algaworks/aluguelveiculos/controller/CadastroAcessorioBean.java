package com.algaworks.aluguelveiculos.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import com.algaworks.aluguelveiculos.modelo.Acessorio;
import com.algaworks.aluguelveiculos.service.CadastroAcessorioService;
import com.algaworks.aluguelveiculos.service.NegocioException;
import com.algaworks.aluguelveiculos.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroAcessorioBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroAcessorioService cadastroAcessorioService;
	private Acessorio acessorio;
	
	@PostConstruct
	public void inicializar(){
		this.limpar();
	}
	
	public void limpar(){
		this.acessorio = new Acessorio();
	}
	
	public void salvar(){
		try {
			cadastroAcessorioService.salvar(acessorio);
			FacesUtil.addSuccessMessage("Acessório Salvo com Sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
		this.limpar();
	}

	public Acessorio getAcessorio() {
		return acessorio;
	}

	public void setAcessorio(Acessorio acessorio) {
		this.acessorio = acessorio;
	}
	
}
