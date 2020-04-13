package com.locadoraveiculosweb.dao;

import static com.locadoraveiculosweb.constants.MessageConstants.BusinessMessages.ERRO_AO_EXCLUIR_O_MODELO_CARRO;
import static com.locadoraveiculosweb.util.messages.MessageUtils.getMessage;

import com.locadoraveiculosweb.modelo.ModeloCarro;

public class ModeloCarroDAO extends BaseDAO<ModeloCarro> {
	private static final long serialVersionUID = 1L;

	@Override
	protected Class<ModeloCarro> getEntityClass() {
		return ModeloCarro.class;
	}

	@Override
	protected String getErroMessage(ModeloCarro object) {
		return getMessage(ERRO_AO_EXCLUIR_O_MODELO_CARRO.getDescription(), object.getDescricao());
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
