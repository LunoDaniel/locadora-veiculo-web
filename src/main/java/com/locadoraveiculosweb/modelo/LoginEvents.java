package com.locadoraveiculosweb.modelo;

import static javax.persistence.EnumType.STRING;

import javax.persistence.Entity;
import javax.persistence.Enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginEvents extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	private String username;
	
	@Enumerated(STRING)
	private LoginStatusEnum status;
	

}
