package com.locadoraveiculosweb.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import com.locadoraveiculosweb.dao.ModeloCarroDAO;
import com.locadoraveiculosweb.modelo.ModeloCarro;
import com.locadoraveiculosweb.service.NegocioException;
import com.locadoraveiculosweb.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaModeloCarroBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<ModeloCarro> modelosCarro;
	
	private ModeloCarro modeloCarroSelecionado;
	
	@Inject
	ModeloCarroDAO modeloCarroDAO;

	public List<ModeloCarro> getModelosCarro() {
		return modelosCarro;
	}
	
	@PostConstruct
	public void inicializar() {
		this.modelosCarro = this.modeloCarroDAO.buscarTodos();
	}
	
	public void excluir() {
		try {
			modeloCarroDAO.excluir(modeloCarroSelecionado);
			this.modelosCarro.remove(modeloCarroSelecionado);
			FacesUtil.addSuccessMessage("Modelo " + modeloCarroSelecionado.getDescricao() + " excluÃ­do com sucesso.");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	
	public ModeloCarro getModeloCarroSelecionado() {
		return modeloCarroSelecionado;
	}
	public void setModeloCarroSelecionado(ModeloCarro modeloCarroSelecionado) {
		this.modeloCarroSelecionado = modeloCarroSelecionado;
	}
	
}
