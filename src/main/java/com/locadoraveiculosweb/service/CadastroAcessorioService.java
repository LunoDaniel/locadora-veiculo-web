package com.locadoraveiculosweb.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.locadoraveiculosweb.dao.AcessorioDAO;
import com.locadoraveiculosweb.modelo.Acessorio;
import com.locadoraveiculosweb.util.jpa.Transactional;

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
