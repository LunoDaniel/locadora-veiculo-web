package com.locadoraveiculosweb.modelo.dtos;

import static java.math.BigDecimal.ZERO;
import static java.math.BigDecimal.valueOf;
import static java.util.Optional.ofNullable;

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
	
	private Integer numeroDiarias;
	
	public void calculateValorTotal() {
		
		carro = ofNullable(carro).orElse(new CarroDto());
		valorTotal = ofNullable(valorTotal).orElse(ZERO);
		numeroDiarias = ofNullable(numeroDiarias).orElse(0);
		
		BigDecimal partial = (ofNullable(carro.getValorDiaria()).orElse(ZERO).multiply(valueOf(numeroDiarias)));
		valorTotal = valorTotal.add(partial);
	}
	
	public BigDecimal getValorTota() {
		return ofNullable(valorTotal).orElse(BigDecimal.valueOf(0.00));
	}

}
