package com.locadoraveiculosweb.modelo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@NamedQueries({
	@NamedQuery( name = "ModeloCarro.findAll", 
				 query = "select mc from ModeloCarro mc " )
				 
})
public class ModeloCarro extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String descricao;

	@ManyToOne
	private Fabricante fabricante;

	@Enumerated(EnumType.STRING)
	private Categoria categoria;

}
