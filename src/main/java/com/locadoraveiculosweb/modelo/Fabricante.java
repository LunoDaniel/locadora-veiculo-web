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
	@NamedQuery( name = "Fabricante.findAll", 
				 query = "select f from Fabricante f " )
				 
})
public class Fabricante extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	private String nome;
	
}
