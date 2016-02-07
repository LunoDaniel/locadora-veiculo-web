package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.DAO.AcessorioDAO;
import com.algaworks.curso.jpa2.DAO.ModeloCarroDAO;
import com.algaworks.curso.jpa2.modelo.Acessorio;
import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.modelo.ModeloCarro;
import com.algaworks.curso.jpa2.service.CadastroCarroService;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroCarroBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroCarroService cadastroCarroService;
	@Inject
	private ModeloCarroDAO modeloCarroDao;
	@Inject
	private AcessorioDAO acessorioDao;
	
	private List<ModeloCarro> modelosCarros;
	private List<Acessorio> acessorios;
	private Carro carro;
	
	@PostConstruct
	public void inicializar(){
		this.limpar();
		this.modelosCarros = this.modeloCarroDao.buscarTodos();
		this.acessorios = acessorioDao.buscarTodos();
	}
	
	public void limpar(){
		this.carro = new Carro();
	}
	
	public void salvar(){
		try {
			this.cadastroCarroService.salvar(carro);
			FacesUtil.addSuccessMessage("Carro salvo com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			FacesUtil.addErrorMessage("Erro desconhecido. Contatar o administrador");
		}
		
		this. 	limpar();
	}

	public List<ModeloCarro> getModelosCarros() {
		return modelosCarros;
	}

	public void setModelosCarros(List<ModeloCarro> modelosCarros) {
		this.modelosCarros = modelosCarros;
	}

	public List<Acessorio> getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(List<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	
	

}
