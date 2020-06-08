package com.locadoraveiculosweb.modelo.dtos;

import java.util.Date;

import com.locadoraveiculosweb.modelo.Sexo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {
	
	Long codigo;
	
	String cpf;
	
	Date dataNascimento;
	
	Sexo sexo;
	
	String nome;
	
	String email;
	
	String telefone;
}
