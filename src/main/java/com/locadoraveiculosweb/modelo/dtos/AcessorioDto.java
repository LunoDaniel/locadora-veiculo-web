package com.locadoraveiculosweb.modelo.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AcessorioDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	private String descricao;
}
