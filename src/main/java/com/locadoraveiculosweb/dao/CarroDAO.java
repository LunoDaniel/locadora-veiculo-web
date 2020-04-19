package com.locadoraveiculosweb.dao;

import com.locadoraveiculosweb.modelo.Carro;

public class CarroDAO extends BaseDAO<Carro> {
	private static final long serialVersionUID = 1L;
	

	public Carro buscarCarroComAcessorios(Long codigo) {
		return (Carro) getEm().createNamedQuery("Carro.findCarWithAcessories")
									.setParameter("codigo", codigo)
							  .getSingleResult();
	}

	@Override
	protected Class<Carro> getEntityClass() {
		return Carro.class;
	}

	@Override
	protected String queryForAll() {
		return "Carro.findAll";
	}

	@Override
	protected String getCacheKey() {
		return "CarrosCache";
	}
}
