package com.locadoraveiculosweb.service;

import java.util.List;

import javax.inject.Inject;

import com.locadoraveiculosweb.dao.AluguelDAO;
import com.locadoraveiculosweb.exception.NegocioException;
import com.locadoraveiculosweb.mappers.AluguelMapper;
import com.locadoraveiculosweb.mappers.CarroMapper;
import com.locadoraveiculosweb.modelo.Aluguel;
import com.locadoraveiculosweb.modelo.dtos.AluguelDto;
import com.locadoraveiculosweb.util.jpa.Transactional;

public class AluguelService implements Service<AluguelDto> {
	private static final long serialVersionUID = 1L;

	@Inject
	private AluguelDAO aluguelDao;
	
	@Inject
	private AluguelMapper aluguelMapper;
	
	@Inject
	private CarroMapper carroMapper;
	
	@Override
	@Transactional
	public AluguelDto salvar(AluguelDto aluguelDto) throws NegocioException{
		if(aluguelDto.getCarro() == null){
			throw new NegocioException("O Carro é Obrigatório para o Aluguel!");
		}
		
		if(aluguelDto.getValorTotal() == null){
			throw new NegocioException("É necessário informar o Valor Total!");
		}
		
		Aluguel aluguel = aluguelMapper.toAluguel(aluguelDto);
		aluguel.setCarro(carroMapper.toCarro(aluguelDto.getCarro()));
		this.aluguelDao.salvar(aluguel);
		
		return aluguelDto;
	}

	@Override
	public AluguelDto buscarPeloCodigo(String id) {
		return null;
	}

	@Override
	public void excluir(AluguelDto viewObject) throws NegocioException {
		
	}

	@Override
	public List<AluguelDto> buscarTodos() {
		return null;
	}
}
