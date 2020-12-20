package com.locadoraveiculosweb.dao;

import java.util.Date;
import java.util.List;

import com.locadoraveiculosweb.modelo.Aluguel;

public class AluguelDAO extends BaseDAO<Aluguel> {
	private static final long serialVersionUID = 1L;

	@Override
	protected Class<Aluguel> getEntityClass() {
		return Aluguel.class;
	}

	@Override
	protected String queryForAll() {
		return "Aluguel.findAll";
	}

	@Override
	protected String getCacheKey() {
		return "aluguelCache";
	}

	@SuppressWarnings("unchecked")
	public List<Aluguel> buscarAlugueisDesde(Date data) {
		return getEm().createQuery("Select a.* From Aluguel a Where a.dataCriacao between :data and now()")
				.setParameter("data", data)
				.getResultList();
	}
	
	

}
