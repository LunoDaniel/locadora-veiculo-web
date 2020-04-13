package com.locadoraveiculosweb.modelo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@NamedQueries(value = {
		@NamedQuery(name = "Carro.findAll", query = "select c from Carro c"),
		@NamedQuery(name = "Carro.findCarWithAcessories", query = "select c from Carro c JOIN c.acessorios a where c.codigo = :codigo"),
})
public class Carro extends BaseEntity {

	private static final long serialVersionUID = 1L;

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
