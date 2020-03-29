package com.locadoraveiculosweb.converter;

import javax.faces.convert.Converter;

public abstract class BeanConverter<T> implements Converter<T> {

	protected abstract String getValue(T value);

}
