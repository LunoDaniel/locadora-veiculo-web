package com.algaworks.aluguelveiculos.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.aluguelveiculos.dao.AcessorioDAO;
import com.algaworks.aluguelveiculos.modelo.Acessorio;
import com.algaworks.aluguelveiculos.util.jpa.Transactional;

public class CadastroAcessorioService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	AcessorioDAO acessorioDao;
	
	@Transactional
	public void salvar(Acessorio acessorio) throws NegocioException{
		if(acessorio.getDescricao() == null || acessorio.getDescricao().trim().equals("")){
			throw new NegocioException("A Descrição do Acessório é Obrigatório!");
		}
		
		acessorioDao.salvar(acessorio);
	}
	
}
