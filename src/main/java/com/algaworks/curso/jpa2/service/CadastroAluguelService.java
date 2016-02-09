package com.algaworks.curso.jpa2.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.dao.AluguelDAO;
import com.algaworks.curso.jpa2.modelo.Aluguel;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class CadastroAluguelService implements Serializable{
	private static final long serialVersionUID = 1L;

	@Inject
	private AluguelDAO aluguelDao;
	
	@Transactional
	public void salvar(Aluguel aluguel) throws NegocioException{
		if(aluguel.getCarro() == null){
			throw new NegocioException("O Carro é Obrigatório para o Aluguel!");
		}
		
		if(aluguel.getValorTotal() == null || aluguel.getValorTotal().equals("")){
			throw new NegocioException("É necessário informar o Valor Total!");
		}
		
		this.aluguelDao.salvar(aluguel);
	}
}
