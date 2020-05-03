package com.locadoraveiculosweb.modelo;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@NamedQueries(value = {
		@NamedQuery(name = "Aluguel.findAll", query = "select a from Aluguel a")
})
public class Aluguel extends BaseEntity {

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
