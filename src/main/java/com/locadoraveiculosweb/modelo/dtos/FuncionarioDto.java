package com.locadoraveiculosweb.modelo.dtos;

import java.util.Date;

import com.locadoraveiculosweb.modelo.Sexo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuncionarioDto extends UsuarioDto {

	FuncionarioDto(Long codigo, String cpf, Date dataNascimento, Sexo sexo, String nome, String email, String telefone) {
		super(codigo, cpf, dataNascimento, sexo, nome, email, telefone);
	}
	
	String matricula;

}
