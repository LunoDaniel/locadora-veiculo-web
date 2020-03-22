package com.algaworks.aluguelveiculos.controller;

import static com.algaworks.aluguelveiculos.constants.MessageConstants.FABRICANTE_EXCLUIDO_COM_SUCESSO;
import static com.algaworks.aluguelveiculos.util.messages.MessageUtils.getMessage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import com.algaworks.aluguelveiculos.dao.FabricanteDAO;
import com.algaworks.aluguelveiculos.modelo.Fabricante;
import com.algaworks.aluguelveiculos.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaFabricanteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	FabricanteDAO fabricanteDAO;
	
	private List<Fabricante> fabricantes = new ArrayList<>();
	
	private Fabricante fabricanteSelecionado;
	
	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}
	
	public void excluir() {
		try {
			fabricanteDAO.excluir(fabricanteSelecionado);
			this.fabricantes.remove(fabricanteSelecionado);
			FacesUtil.addSuccessMessage(getMessage(FABRICANTE_EXCLUIDO_COM_SUCESSO, fabricanteSelecionado.getNome()));
		} catch (Exception e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public Fabricante getFabricanteSelecionado() {
		return fabricanteSelecionado;
	}
	public void setFabricanteSelecionado(Fabricante fabricanteSelecionado) {
		this.fabricanteSelecionado = fabricanteSelecionado;
	}
	
	@PostConstruct
	public void inicializar() {
		fabricantes = fabricanteDAO.buscarTodos();
	}
}