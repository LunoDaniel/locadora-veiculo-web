package com.algaworks.aluguelveiculos.modelo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper=false)
@DiscriminatorValue(value = "FUNCIONARIO ")
public class Funcionario extends Pessoa {

	private static final long serialVersionUID = 1L;
	
	String matricula;
}
