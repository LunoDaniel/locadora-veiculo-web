package com.locadoraveiculosweb.dao;

import com.locadoraveiculosweb.modelo.ModeloCarro;

public class ModeloCarroDAO extends BaseDAO<ModeloCarro> {
	private static final long serialVersionUID = 1L;

	@Override
	protected Class<ModeloCarro> getEntityClass() {
		return ModeloCarro.class;
	}

	@Override
	protected String queryForAll() {
		return "ModeloCarro.findAll";
	}

	@Override
	protected String getCacheKey() {
		return "modeloCarroCache";
	}
	
}
