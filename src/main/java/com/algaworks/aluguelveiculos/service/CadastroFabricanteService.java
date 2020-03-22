package com.algaworks.aluguelveiculos.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.aluguelveiculos.dao.FabricanteDAO;
import com.algaworks.aluguelveiculos.modelo.Fabricante;
import com.algaworks.aluguelveiculos.util.jpa.Transactional;

public class CadastroFabricanteService implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private FabricanteDAO fabricanteDAO;
	
	@Transactional
	public Fabricante salvar(Fabricante fabricante) throws NegocioException{
		if(fabricante.getNome() == null || fabricante.getNome().trim().equals("")){
			throw new NegocioException("O nome do Fabricante é Obrigatório");
		}
		
		return this.fabricanteDAO.salvar(fabricante);
	}
}
