package com.algaworks.curso.jpa2.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.DAO.CarroDAO;
import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class CadastroCarroService implements Serializable{
	private static final long serialVersionUID = 1L;

	@Inject
	private CarroDAO carroDao;
	
	@Transactional
	public void salvar(Carro carro) throws NegocioException{
		if(carro.getChassi() == null || carro.getChassi().trim().equals("")){
			throw new NegocioException("O Chassi é um campo Obrigatório!");
		}
		
		if(carro.getModelo() == null ){
			throw new NegocioException("O Modelo é um campo Obrigatório!");
		}
		
		if(carro.getPlaca() == null || carro.getPlaca().trim().equals("")){
			throw new NegocioException("A Placa é um campo Obrigatório!");
		}
		
		if(carro.getCor() == null || carro.getCor().trim().equals("")){
			throw new NegocioException("A Cor é um campo Obrigatório!");
		}
		
		this.carroDao.salvar(carro);
	}
}
