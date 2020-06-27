package com.locadoraveiculosweb.modelo.dtos;

import java.util.Date;

import com.locadoraveiculosweb.modelo.Sexo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MotoristaDto extends UsuarioDto {

	MotoristaDto(Long codigo, String cpf, Date dataNascimento, String password, Sexo sexo, String nome, String email, String telefone) {
		super(codigo, cpf, dataNascimento, password, sexo, nome, email, telefone);
	}
	
	String cnh;
}
