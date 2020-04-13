package com.locadoraveiculosweb.dao;

import static com.locadoraveiculosweb.constants.MessageConstants.BusinessMessages.ERRO_AO_EXCLUIR_O_CARRO;
import static com.locadoraveiculosweb.util.messages.MessageUtils.getMessage;

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
	protected String getErroMessage(Carro object) {
		return getMessage(ERRO_AO_EXCLUIR_O_CARRO.getDescription(), object.getChassi()) ;
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
