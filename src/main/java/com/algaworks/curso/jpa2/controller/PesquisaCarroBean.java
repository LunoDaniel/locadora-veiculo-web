package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.DAO.CarroDAO;
import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaCarroBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	CarroDAO carroDao;
	
	private Carro carroSelecionado;
	private List<Carro> carros;
	
	@PostConstruct
	public void inicializar(){
		this.carros = carroDao.buscarTodos();
	}

	public void excluir() throws NegocioException{
		try {
			this.carroDao.excluir(carroSelecionado);
			this.carros.remove(carroSelecionado);
			FacesUtil.addSuccessMessage("Carro Removido com Sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public Carro getCarroSelecionado() {
		return carroSelecionado;
	}

	public void setCarroSelecionado(Carro carroSelecionado) {
		this.carroSelecionado = carroSelecionado;
	}

	public List<Carro> getCarros() {
		return carros;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}
	
	
}
