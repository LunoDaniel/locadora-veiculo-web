package com.locadoraveiculosweb.modelo;

import lombok.Getter;

public enum Sexo {	
	
	MASCULINO("Masculino"),
	FMININO("Feminino"),
	NAO_INFORMAR("Não Informar");
	
	@Getter
	String descricao;
	
	Sexo(String descricao) {
		this.descricao = descricao;
	}
}
