package com.locadoraveiculosweb.dao;

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

}
