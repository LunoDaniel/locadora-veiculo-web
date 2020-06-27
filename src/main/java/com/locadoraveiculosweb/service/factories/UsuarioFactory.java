package com.locadoraveiculosweb.service.factories;

import javax.inject.Inject;

import com.locadoraveiculosweb.mappers.UsuarioMapper;
import com.locadoraveiculosweb.modelo.Usuario;
import com.locadoraveiculosweb.modelo.dtos.FuncionarioDto;
import com.locadoraveiculosweb.modelo.dtos.MotoristaDto;
import com.locadoraveiculosweb.modelo.dtos.UsuarioDto;

import lombok.Getter;

public class UsuarioFactory {
	
	@Getter
	@Inject
	UsuarioMapper mapper;

	public Usuario get(UsuarioDto dto) {
		
		if(dto instanceof MotoristaDto)
			return mapper.toMotorista((MotoristaDto) dto);
		
		return mapper.toFuncionario((FuncionarioDto) dto);
	}

}
