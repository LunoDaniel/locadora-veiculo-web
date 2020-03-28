package com.locadoraveiculosweb.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.locadoraveiculosweb.dao.ModeloCarroDAO;
import com.locadoraveiculosweb.modelo.ModeloCarro;
import com.locadoraveiculosweb.util.jpa.Transactional;

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