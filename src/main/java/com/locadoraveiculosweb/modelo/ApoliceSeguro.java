package com.locadoraveiculosweb.modelo;

import java.math.BigDecimal;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ApoliceSeguro extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	private BigDecimal valorFranquia;
	private Boolean protecaoTerceiro;
	private Boolean protecaoCausasNaturais;
	private Boolean protecaoRoubo;

}
