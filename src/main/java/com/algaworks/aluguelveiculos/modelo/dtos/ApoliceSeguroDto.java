package com.algaworks.aluguelveiculos.modelo.dtos;

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
public class ApoliceSeguroDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	private BigDecimal valorFranquia;
	private Boolean protecaoTerceiro;
	private Boolean protecaoCausasNaturais;
	private Boolean protecaoRoubo;


}
