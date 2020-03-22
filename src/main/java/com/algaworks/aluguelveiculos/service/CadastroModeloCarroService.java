package com.algaworks.aluguelveiculos.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.aluguelveiculos.dao.ModeloCarroDAO;
import com.algaworks.aluguelveiculos.modelo.ModeloCarro;
import com.algaworks.aluguelveiculos.util.jpa.Transactional;

public class CadastroModeloCarroService implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ModeloCarroDAO modeloCarroDAO;

	@Transactional
	public void salvar(ModeloCarro modeloCarro) throws NegocioException {
		if (modeloCarro.getDescricao() == null || modeloCarro.getDescricao().trim().equals("")) {
			throw new NegocioException("O nome do modelo é obrigatório.");
		}
		
		if (modeloCarro.getFabricante() == null) {
			throw new NegocioException("O fabricante e obrigatório");
		}
		
		this.modeloCarroDAO.salvar(modeloCarro);
	}

	
}