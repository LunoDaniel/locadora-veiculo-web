package com.locadoraveiculosweb.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.locadoraveiculosweb.dao.AluguelDAO;
import com.locadoraveiculosweb.modelo.Aluguel;
import com.locadoraveiculosweb.util.jpa.Transactional;

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
