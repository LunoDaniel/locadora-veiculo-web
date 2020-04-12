package com.locadoraveiculosweb.constants;

import lombok.Getter;

@Getter
public enum LabelConstants {

	NOVO_FABRICANTE("Novo Fabricante"), PESQUISA_FABRICANTE("Pesquisa Fabricantes"),
	NOVO_ACESSORIO("Novo Acessório"), PESQUISA_ACESSORIO("Pesquisa Acessório");
	
	

	String value;

	private LabelConstants(String value) {
		this.value = value;
	}
}
