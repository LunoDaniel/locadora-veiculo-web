package com.locadoraveiculosweb.mappers;

import java.util.List;

import javax.enterprise.inject.Model;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.locadoraveiculosweb.modelo.Aluguel;
import com.locadoraveiculosweb.modelo.dtos.AluguelDto;

@Model
@Mapper(componentModel = "cdi")
public interface AluguelMapper {

	@Mapping(target = "carro", ignore = true)
	Aluguel toAluguel(AluguelDto dto);

	@Mapping(target = "carro", ignore = true)
	AluguelDto toAluguelDto(Aluguel entity);

	List<Aluguel> toAluguel(List<AluguelDto> dto);

	List<AluguelDto> toAluguelDto(List<Aluguel> entity);
}
