package com.algaworks.aluguelveiculos.modelo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class ApoliceSeguro implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;
	private BigDecimal valorFranquia;
	private Boolean protecaoTerceiro;
	private Boolean protecaoCausasNaturais;
	private Boolean protecaoRoubo;


}
