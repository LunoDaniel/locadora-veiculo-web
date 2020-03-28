package com.locadoraveiculosweb.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import com.locadoraveiculosweb.dao.FabricanteDAO;
import com.locadoraveiculosweb.modelo.Categoria;
import com.locadoraveiculosweb.modelo.Fabricante;
import com.locadoraveiculosweb.modelo.ModeloCarro;
import com.locadoraveiculosweb.service.CadastroModeloCarroService;
import com.locadoraveiculosweb.service.NegocioException;
import com.locadoraveiculosweb.util.jsf.FacesUtil;

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
