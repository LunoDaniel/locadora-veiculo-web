package com.locadoraveiculosweb.modelo;

import lombok.Getter;

public enum Categoria {
	HATCH_COMPACTO("Hatch Compacto"),
	HATCH_MEDIO("Hatch Médio"),
	SEDAN_COMPACTO("Sedan Compacto"),
	SEDAN_MEDIO("Sedan Médio"),
	SEDAN_GRANDE("Sedan Grande"),
	MINIVAN("Mini-Van"),
	ESPORTIVO("Esportivo"),
	UTILITARIO_COMERCIAL("Utilitário Comercial");
	
	@Getter String description;
	Categoria(String description) {
		this.description = description;
	}
}
