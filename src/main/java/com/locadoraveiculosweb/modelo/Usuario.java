package com.locadoraveiculosweb.modelo;

import static javax.persistence.DiscriminatorType.STRING;
import static javax.persistence.InheritanceType.SINGLE_TABLE;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Inheritance(strategy = SINGLE_TABLE)
@DiscriminatorColumn(name="tipo_usuario", discriminatorType = STRING)
@NamedQueries(value = { 
		@NamedQuery(name = "Usuario.FindAll", query = "select u from Usuario u"),
		@NamedQuery(name = "Usuario.FindOneByUsernameAndPass", query = "select u from Usuario u where u.cpf = :username and u.password = :password")
})
public class Usuario extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long codigo;
	
	String cpf;
	
	String password;
	
	@Column(name="data_nascimento")
	@Temporal(TemporalType.DATE)
	Date dataNascimento;
	
	@Enumerated(EnumType.STRING)
	Sexo sexo;
	
}
