package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.DAO.AcessorioDAO;
import com.algaworks.curso.jpa2.modelo.Acessorio;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaAcessorioBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private AcessorioDAO acessorioDao;
	
	private Acessorio acessorioSelecionado;
	private List<Acessorio> acessorios;
	
	public void excluir(){
		try {
			this.acessorioDao.excluir(acessorioSelecionado);
			this.acessorios.remove(acessorioSelecionado);
			FacesUtil.addSuccessMessage("Acessório Removido com Sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	
	@PostConstruct
	public void inicializar(){
		this.acessorios = acessorioDao.buscarTodos();
	}

	public Acessorio getAcessorioSelecionado() {
		return acessorioSelecionado;
	}

	public void setAcessorioSelecionado(Acessorio acessorioSelecionado) {
		this.acessorioSelecionado = acessorioSelecionado;
	}

	public List<Acessorio> getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(List<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}
	
	
}
