package com.locadoraveiculosweb.converter;

import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;
import static org.apache.commons.lang3.StringUtils.EMPTY;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.apache.commons.lang3.StringUtils;

import com.locadoraveiculosweb.service.Service;

public abstract class BeanConverter<T> implements Converter<T> {

	protected abstract String getValue(T value);
	
	protected abstract Service<T> getService(); 
	
	@Override
	public T getAsObject(FacesContext context, UIComponent component, String value) {
		if(StringUtils.isBlank(value)) return null;
		return getService().buscarPeloCodigo(value);
	}
	
	public String getAsString(FacesContext context, UIComponent component, T value) {
		return (isNotEmpty(value)) ? getValue(value) : EMPTY;
	}
	
}
