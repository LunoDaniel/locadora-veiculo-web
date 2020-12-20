package com.locadoraveiculosweb.constants;

import lombok.Getter;

@Getter
public enum LabelConstants {

	NOVO_FABRICANTE("Novo Fabricante"), PESQUISA_FABRICANTE("Pesquisa Fabricantes"),
	NOVO_ACESSORIO("Novo Acessório"), PESQUISA_ACESSORIO("Pesquisa Acessório"),
	NOVO_MODELO_CARRO("Novo Modelo Carro"), PESQUISA_MODELO_CARRO("Pesquisa Modelo Carro"),
	NOVO_CARRO("Novo Carro"), PESQUISA_CARRO("Pesquisa Carro"), NOVO_ALUGUEL("Novo Aluguel"),
	RELATORIO_ALGUEL_PERIODO("Relatório de Aluguéis");

	String value;

	private LabelConstants(String value) {
		this.value = value;
	}
}
