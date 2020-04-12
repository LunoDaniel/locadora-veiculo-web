package com.locadoraveiculosweb.dao;

import static com.locadoraveiculosweb.constants.MessageConstants.ViewMessages.ERRO_AO_EXCLUIR_O_FABRICANTE;
import static com.locadoraveiculosweb.util.messages.MessageUtils.getMessage;

import com.locadoraveiculosweb.modelo.Fabricante;

public class FabricanteDAO extends BaseDAO<Fabricante> {
	private static final long serialVersionUID = 1L;

	@Override
	protected Class<Fabricante> getEntityClass() {
		return Fabricante.class;
	}

	@Override
	protected String getErroMessage(Fabricante object) {
		return getMessage(ERRO_AO_EXCLUIR_O_FABRICANTE.getDescription(), object.getNome());
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
