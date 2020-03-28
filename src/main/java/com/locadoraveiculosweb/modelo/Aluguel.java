package com.locadoraveiculosweb.modelo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Aluguel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;
	private BigDecimal valorTotal;
	
	@ManyToOne
	private Carro carro;
	@OneToOne(cascade=CascadeType.ALL)
	private ApoliceSeguro apoliceSeguro;
	
	
}
