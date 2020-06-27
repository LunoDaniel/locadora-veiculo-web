package com.locadoraveiculosweb.mappers;

import org.mapstruct.Mapper;

import com.locadoraveiculosweb.modelo.Funcionario;
import com.locadoraveiculosweb.modelo.Motorista;
import com.locadoraveiculosweb.modelo.Usuario;
import com.locadoraveiculosweb.modelo.dtos.FuncionarioDto;
import com.locadoraveiculosweb.modelo.dtos.MotoristaDto;
import com.locadoraveiculosweb.modelo.dtos.UsuarioDto;

@Mapper(componentModel = "cdi")
public interface UsuarioMapper {
	
	Motorista toMotorista(MotoristaDto dto);
	Funcionario toFuncionario(FuncionarioDto dto);
	
	UsuarioDto toUsuarioDto(Usuario entity);
	Usuario toUsuario(UsuarioDto entity);
}
