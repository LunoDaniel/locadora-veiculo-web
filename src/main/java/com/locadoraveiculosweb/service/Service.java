package com.locadoraveiculosweb.service;

import java.io.Serializable;
import java.util.List;

import com.locadoraveiculosweb.exception.NegocioException;

public interface Service<T> extends Serializable {
	
	T salvar(T object) throws NegocioException;
	
	T buscarPeloCodigo(String id);

	void excluir(T viewObject) throws NegocioException;

	List<T> buscarTodos();

}
