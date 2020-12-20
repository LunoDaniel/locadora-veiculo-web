package com.locadoraveiculosweb.dao.relatorios;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import com.locadoraveiculosweb.dao.AluguelDAO;
import com.locadoraveiculosweb.modelo.Aluguel;

public class RelatorioAluguelDAO {
	
	@Inject
	AluguelDAO dao;
	
	public List<Aluguel> buscarAlugueisDesde(Date data) {
		return dao.buscarAlugueisDesde(data);
	}
}
