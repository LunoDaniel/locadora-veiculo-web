package com.locadoraveiculosweb.modelo.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarroDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long codigo;
	
	private BigDecimal valorDiaria;
	private String placa;
	private String chassi;
	private String cor;
	
	private List<AluguelDto> alugueis;
	private AcessorioDto[] acessorios;
	private ModeloCarroDto modelo;
	
}
