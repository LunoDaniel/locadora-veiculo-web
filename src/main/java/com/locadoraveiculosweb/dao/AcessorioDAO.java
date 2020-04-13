package com.locadoraveiculosweb.dao;

import static com.locadoraveiculosweb.constants.MessageConstants.BusinessMessages.ERRO_AO_EXCLUIR_O_ACESSORIO;
import static com.locadoraveiculosweb.util.messages.MessageUtils.getMessage;

import com.locadoraveiculosweb.modelo.Acessorio;

public class AcessorioDAO extends BaseDAO<Acessorio> {
	private static final long serialVersionUID = 1L;

	@Override
	protected Class<Acessorio> getEntityClass() {
		return Acessorio.class;
	}

	@Override
	protected String getErroMessage(Acessorio object) {
		return getMessage(ERRO_AO_EXCLUIR_O_ACESSORIO.getDescription(), object.getDescricao());
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
