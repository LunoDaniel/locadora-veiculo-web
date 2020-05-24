package com.locadoraveiculosweb.mappers;

import org.mapstruct.Mapper;

import com.locadoraveiculosweb.modelo.Usuario;
import com.locadoraveiculosweb.modelo.dtos.UsuarioDto;

@Mapper(componentModel = "cdi")
public interface UsuarioMapper {
	
	Usuario toUsuario(UsuarioDto dto);
	UsuarioDto toUsuarioDto(Usuario entity);

}
