package com.locadoraveiculosweb.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.locadoraveiculosweb.modelo.ApoliceSeguro;
import com.locadoraveiculosweb.modelo.dtos.ApoliceSeguroDto;


@Mapper(componentModel = "cdi")
public interface ApoliceSeguroMapper {
	
	ApoliceSeguro toApoliceSeguro(ApoliceSeguroDto dto);
	ApoliceSeguroDto toApoliceSeguroDto(ApoliceSeguro entity);
	
	List<ApoliceSeguro> toApoliceSeguro(List<ApoliceSeguroDto> dto);
	List<ApoliceSeguroDto> toApoliceSeguroDto(List<ApoliceSeguro> entity);

}
