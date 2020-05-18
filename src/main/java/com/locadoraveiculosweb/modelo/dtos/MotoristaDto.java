package com.locadoraveiculosweb.modelo.dtos;

import java.util.Date;

import com.locadoraveiculosweb.modelo.Sexo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MotoristaDto extends UsuarioDto {

	MotoristaDto(Long codigo, String cpf, Date dataNascimento, Sexo sexo) {
		super(codigo, cpf, dataNascimento, sexo);
	}
	
	String cnh;
}
