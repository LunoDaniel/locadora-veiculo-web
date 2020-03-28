package com.algaworks.aluguelveiculos.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.aluguelveiculos.dao.AluguelDAO;
import com.algaworks.aluguelveiculos.modelo.Aluguel;
import com.algaworks.aluguelveiculos.util.jpa.Transactional;

public class CadastroAluguelService implements Serializable{
	private static final long serialVersionUID = 1L;

	@Inject
	private AluguelDAO aluguelDao;
	
	@Transactional
	public void salvar(Aluguel aluguel) throws NegocioException{
		if(aluguel.getCarro() == null){
			throw new NegocioException("O Carro é Obrigatório para o Aluguel!");
		}
		
		if(aluguel.getValorTotal() == null){
			throw new NegocioException("É necessário informar o Valor Total!");
		}
		
		this.aluguelDao.salvar(aluguel);
	}
}
