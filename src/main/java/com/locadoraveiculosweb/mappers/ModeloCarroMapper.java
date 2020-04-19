package com.locadoraveiculosweb.mappers;

import static org.mapstruct.CollectionMappingStrategy.ACCESSOR_ONLY;

import java.util.List;

import javax.enterprise.inject.Model;

import org.mapstruct.Mapper;

import com.locadoraveiculosweb.modelo.ModeloCarro;
import com.locadoraveiculosweb.modelo.dtos.ModeloCarroDto;

@Model
@Mapper(componentModel = "cdi", uses = FabricateMapper.class, collectionMappingStrategy = ACCESSOR_ONLY)
public interface ModeloCarroMapper {
	
	ModeloCarro toModeloCarro(ModeloCarroDto dto);
	ModeloCarroDto toModeloCarroDto(ModeloCarro entity);
	
	List<ModeloCarro> toModeloCarro(List<ModeloCarroDto> dto);
	List<ModeloCarroDto> toModeloCarroDto(List<ModeloCarro> entity);

}
