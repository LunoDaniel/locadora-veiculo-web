package com.locadoraveiculosweb.service;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import com.locadoraveiculosweb.dao.relatorios.RelatorioAluguelDAO;
import com.locadoraveiculosweb.mappers.AluguelMapper;
import com.locadoraveiculosweb.modelo.dtos.AluguelDto;

public class RelatoriosAlguelService {
	
	@Inject
	private RelatorioAluguelDAO ralatorioAluguelDao;
	
	@Inject
	private AluguelMapper mapper;
	
	public List<AluguelDto> relatorioAluguelDesde(Date data) {
		return mapper.toAluguelDto(ralatorioAluguelDao.buscarAlugueisDesde(data));
	}

}
