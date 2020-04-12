package com.locadoraveiculosweb.dao;

import static com.locadoraveiculosweb.constants.MessageConstants.ViewMessages.MODELO_CARRO_EXCLUIDO_COM_SUCESSO;
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
		return getMessage(MODELO_CARRO_EXCLUIDO_COM_SUCESSO.getDescription(), object.getDescricao());
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
