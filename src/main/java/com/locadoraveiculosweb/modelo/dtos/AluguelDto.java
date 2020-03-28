package com.locadoraveiculosweb.modelo.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AluguelDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	private BigDecimal valorTotal;
	private CarroDto carro;
	private ApoliceSeguroDto apoliceSeguro;
	
	
}
