package com.algaworks.aluguelveiculos.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Carro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;
	
	private BigDecimal valorDiaria;
	private String placa;
	private String chassi;
	private String cor;
	
	@OneToMany(mappedBy="carro")
	private List<Aluguel> alugueis;
	@ManyToMany
	private List<Acessorio> acessorios;
	@ManyToOne
	private ModeloCarro modelo;
	
}
