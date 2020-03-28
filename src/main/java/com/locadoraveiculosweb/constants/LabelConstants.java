package com.locadoraveiculosweb.constants;

import lombok.Getter;

@Getter
public enum LabelConstants {

	NOVO_FABRICANTE("Novo Fabricante"), PESQUISA_FABRICANTE("Pesquisa Fabricantes");

	String value;

	private LabelConstants(String value) {
		this.value = value;
	}
}
