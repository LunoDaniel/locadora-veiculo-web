package com.locadoraveiculosweb.controller;

import static com.locadoraveiculosweb.util.jsf.FacesUtil.addErrorMessage;
import static com.locadoraveiculosweb.util.jsf.FacesUtil.addSuccessMessage;
import static com.locadoraveiculosweb.util.messages.MessageUtils.getMessage;

import java.io.Serializable;
import java.util.List;

import com.locadoraveiculosweb.constants.LabelConstants;
import com.locadoraveiculosweb.service.NegocioException;
import com.locadoraveiculosweb.service.Service;

public abstract class BeanController<T> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public String getPageTitle(String label) {
		return LabelConstants.valueOf(label).getValue();
	}
	
	public void salvar(){
		try {
			T salvo = getService().salvar(getViewObject());
			addSuccessMessage(getMessage(getSuccessMessage(salvo)));
			clean();
		} catch (NegocioException e) {
			addErrorMessage(e.getMessage());
		}
	}
	
	public void excluir() {
		try {
			getService().excluir(getViewObject());
			addSuccessMessage(getSuccessMessage(getViewObject()));
			clean();
		} catch (NegocioException e) {
			addErrorMessage(e.getMessage());
		} 
	}
	
	public List<T> buscarTodos() {
		return getService().buscarTodos();
	} 
	
	public T buscarTodos(String id) {
		return getService().buscarPeloCodigo(id);
	}
	
	public abstract void initializer();
	
	protected abstract void clean();
	
	protected abstract Service<T> getService();
	
	protected abstract T getViewObject();
	
	protected abstract String getSuccessMessage(T object);

}
