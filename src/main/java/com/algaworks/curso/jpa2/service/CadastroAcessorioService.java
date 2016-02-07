package com.algaworks.curso.jpa2.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.DAO.AcessorioDAO;
import com.algaworks.curso.jpa2.modelo.Acessorio;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

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
