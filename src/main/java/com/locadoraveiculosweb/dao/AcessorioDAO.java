package com.locadoraveiculosweb.dao;

import com.locadoraveiculosweb.modelo.Acessorio;

public class AcessorioDAO extends BaseDAO<Acessorio> {
	private static final long serialVersionUID = 1L;

	@Override
	protected Class<Acessorio> getEntityClass() {
		return Acessorio.class;
	}

	@Override
	protected String queryForAll() {
		return "Acessorio.findAll";
	}

	@Override
	protected String getCacheKey() {
		return "acessorioCache";
	}
}
