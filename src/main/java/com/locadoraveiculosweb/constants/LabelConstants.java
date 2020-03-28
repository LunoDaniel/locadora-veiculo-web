package com.algaworks.aluguelveiculos.constants;

import lombok.Getter;

@Getter
public enum LabelConstants {

	NOVO_FABRICANTE("Novo Fabricante"), PESQUISA_FABRICANTE("Novo Fabricante");

	String value;

	private LabelConstants(String value) {
		this.value = value;
	}
}
