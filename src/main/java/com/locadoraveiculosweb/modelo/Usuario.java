package com.locadoraveiculosweb.modelo;

import static javax.persistence.DiscriminatorType.STRING;
import static javax.persistence.InheritanceType.SINGLE_TABLE;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Inheritance(strategy = SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_usuario", discriminatorType = STRING)
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "email", "cpf" }) })
@NamedQueries(value = { @NamedQuery(name = "Usuario.FindAll", query = "select u from Usuario u"),
		@NamedQuery(name = "Usuario.FindOneByUsernameAndPass", query = "select u from Usuario u where u.email = :email") })
public class Usuario extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@NotBlank
	String cpf;
	
	@NotBlank
	@Size(min = 3)
	String nome;

	@Email(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
	@NotBlank
	String email;
	
	@NotBlank
	String telefone;

	@NotBlank
	String password;

	@Column(name = "data_nascimento")
	@Temporal(TemporalType.DATE)
	Date dataNascimento;

	@Enumerated(EnumType.STRING)
	Sexo sexo;

}
