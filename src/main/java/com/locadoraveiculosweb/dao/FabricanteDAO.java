package com.locadoraveiculosweb.dao;

import com.locadoraveiculosweb.modelo.Fabricante;

public class FabricanteDAO extends BaseDAO<Fabricante> {
	private static final long serialVersionUID = 1L;

	@Override
	protected Class<Fabricante> getEntityClass() {
		return Fabricante.class;
	}

	@Override
	protected String queryForAll() {
		return "Fabricante.findAll";
	}

	@Override
	protected String getCacheKey() {
		return "fanbricanteCache";
	}
}
