package com.locadoraveiculosweb.modelo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper=false)
@DiscriminatorValue(value = "MOTORISTA")
public class Motorista extends Pessoa {
	
	private static final long serialVersionUID = 1L;
	
	String cnh;
}
