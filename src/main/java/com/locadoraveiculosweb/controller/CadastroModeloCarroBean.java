package com.algaworks.aluguelveiculos.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import com.algaworks.aluguelveiculos.dao.FabricanteDAO;
import com.algaworks.aluguelveiculos.modelo.Categoria;
import com.algaworks.aluguelveiculos.modelo.Fabricante;
import com.algaworks.aluguelveiculos.modelo.ModeloCarro;
import com.algaworks.aluguelveiculos.service.CadastroModeloCarroService;
import com.algaworks.aluguelveiculos.service.NegocioException;
import com.algaworks.aluguelveiculos.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroModeloCarroBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private ModeloCarro modeloCarro;
	private List<Fabricante> fabricantes;
	private List<Categoria> categorias;
	
	@Inject
	private CadastroModeloCarroService cadastroModeloCarroService;
	@Inject
	private FabricanteDAO fabricanteDao;
	
	public void salvar(){
		try {
			this.cadastroModeloCarroService.salvar(modeloCarro);
			FacesUtil.addSuccessMessage("Modelo Salvo com Sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
		
		this.limpar();
	}
	
	@PostConstruct
	public void inicializar(){
		this.limpar();
		this.setFabricantes(fabricanteDao.buscarTodos());
		this.categorias = Arrays.asList(Categoria.values());
	}
	
	public void limpar(){
		this.modeloCarro = new ModeloCarro();
	}

	public ModeloCarro getModeloCarro() {
		return modeloCarro;
	}

	public void setModeloCarro(ModeloCarro modeloCarro) {
		this.modeloCarro = modeloCarro;
	}

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

}
