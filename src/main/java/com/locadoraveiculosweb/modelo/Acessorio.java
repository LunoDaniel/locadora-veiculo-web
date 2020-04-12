package com.locadoraveiculosweb.modelo;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@NamedQueries({
	@NamedQuery( name = "Acessorio.findAll", 
				 query = "select a from Acessorio a " )
				 
})
public class Acessorio extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String descricao;
}
