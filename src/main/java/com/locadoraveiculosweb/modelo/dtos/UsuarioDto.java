package com.locadoraveiculosweb.modelo.dtos;

import java.util.Date;

import com.locadoraveiculosweb.modelo.Sexo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioDto {
	
	Long codigo;
	
	String cpf;
	
	Date dataNascimento;
	
	Sexo sexo;
}
