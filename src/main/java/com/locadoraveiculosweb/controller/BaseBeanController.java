package com.locadoraveiculosweb.controller;

import static com.locadoraveiculosweb.constants.LabelConstants.valueOf;
import static com.locadoraveiculosweb.constants.MessageConstants.ViewMessages.getMsgFor;
import static com.locadoraveiculosweb.constants.ServiceConstants.ERRO;
import static com.locadoraveiculosweb.constants.ServiceConstants.EXCLUIR;
import static com.locadoraveiculosweb.constants.ServiceConstants.SALVAR;
import static com.locadoraveiculosweb.constants.ServiceConstants.SUCESSO;
import static com.locadoraveiculosweb.util.jsf.FacesUtil.addErrorMessage;
import static com.locadoraveiculosweb.util.jsf.FacesUtil.addSuccessMessage;

import java.io.Serializable;
import java.util.List;

import com.locadoraveiculosweb.exception.NegocioException;
import com.locadoraveiculosweb.service.Service;
import com.locadoraveiculosweb.util.messages.MessageUtils;

public abstract class BaseBeanController<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public String getPageTitle(String label) {
		return valueOf(label).getValue();
	}

	public void salvar() throws NegocioException {
		T object = null;
		try {
			object = getService().salvar(getViewObject());
			setViewObject(object);
			addSuccessMessage(getMessage(SALVAR, SUCESSO));
			clean();
		} catch (NegocioException e) {
			addErrorMessage(getMessage(SALVAR, ERRO));
		}
	}

	public void excluir(T dto) throws NegocioException {
		try {
			setViewObject(dto);
			getService().excluir(dto);
			addSuccessMessage(getMessage(EXCLUIR, SUCESSO));
			clean();
		} catch (NegocioException e) {
			addErrorMessage(getMessage(EXCLUIR, ERRO));
		}
	}

	public List<T> buscarTodos() {
		return getService().buscarTodos();
	}

	public T buscarTodos(String id) {
		return getService().buscarPeloCodigo(id);
	}
	
	private String getMessage(String msgFor, String typeOfMsg) throws NegocioException {
		return MessageUtils.getMessage(getMsgFor(msgFor, typeOfMsg), getNameMessage(), getViewObjectPropertyMsg());
	}

	public abstract void initializer();

	protected abstract void clean();

	protected abstract Service<T> getService();

	protected abstract T getViewObject();
	
	protected abstract void setViewObject(T dto);
	
	protected abstract String getNameMessage();
	
	protected abstract String getViewObjectPropertyMsg();

}
