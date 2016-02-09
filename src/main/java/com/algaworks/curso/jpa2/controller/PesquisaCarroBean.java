package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.dao.AcessorioDAO;
import com.algaworks.curso.jpa2.dao.CarroDAO;
import com.algaworks.curso.jpa2.modelo.Acessorio;
import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaCarroBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CarroDAO carroDao;
	@Inject
	private AcessorioDAO acessorioDao;
	
	private List<Carro> carros;
	private List<Acessorio> acessorios;
	private Carro carroSelecionado;
	
	@PostConstruct
	public void inicializar(){
		this.carros = carroDao.buscarTodos();
		this.acessorios = acessorioDao.buscarTodos();
	}
	
	public void excluir(){
		try {
			this.carroDao.excluir(carroSelecionado);
			this.carros.remove(carroSelecionado);
			FacesUtil.addSuccessMessage("Carro "+ carroSelecionado.getModelo() +" foi Excluído com Sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public void buscarCarroComAcessorios() {
		carroSelecionado = carroDao.buscarCarroComAcessorios(carroSelecionado.getCodigo());
	}
	
	public List<Carro> getCarros() {
		return carros;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}

	public Carro getCarroSelecionado() {
		return carroSelecionado;
	}

	public void setCarroSelecionado(Carro carroSelecionado) {
		this.carroSelecionado = carroSelecionado;
	}

	public List<Acessorio> getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(List<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}

}
