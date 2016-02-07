package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.modelo.Acessorio;
import com.algaworks.curso.jpa2.service.CadastroAcessorioService;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

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
