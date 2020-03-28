package com.locadoraveiculosweb.service;

import static java.util.Optional.ofNullable;
import static org.apache.commons.lang3.StringUtils.isBlank;

import java.util.List;

import javax.inject.Inject;

import com.locadoraveiculosweb.dao.FabricanteDAO;
import com.locadoraveiculosweb.mappers.FabricateMapper;
import com.locadoraveiculosweb.modelo.Fabricante;
import com.locadoraveiculosweb.modelo.dtos.FabricanteDto;
import com.locadoraveiculosweb.util.jpa.Transactional;

public class FabricanteService implements Service<FabricanteDto> {
	private static final long serialVersionUID = 1L;

	@Inject
	private FabricanteDAO fabricanteDAO;

	@Inject
	private FabricateMapper mapper;

	@Transactional
	public FabricanteDto salvar(FabricanteDto fabricanteDto) throws NegocioException {
		
		if(isBlank(fabricanteDto.getNome())) {
			throw new NegocioException("O nome do Fabricante é Obrigatório");
		}
		
		Fabricante fabricante = mapper.toFabricante(ofNullable(fabricanteDto).orElse(new FabricanteDto()));
		fabricante = fabricanteDAO.salvar(fabricante);
		
		return mapper.toFabricanteDto(fabricante);
	}
	
	@Override
	public FabricanteDto buscarPeloCodigo(String codigo) {
		Fabricante fabricante = this.fabricanteDAO.buscarPeloCodigo(new Long(codigo));
		return mapper.toFabricanteDto(ofNullable(fabricante).orElse(null));
	}

	@Override
	public void excluir(FabricanteDto viewObject) throws NegocioException {
		Fabricante fabricante = mapper.toFabricante(viewObject);
		fabricanteDAO.excluir(fabricante);
	}

	@Override
	public List<FabricanteDto> buscarTodos() {
		return mapper.toFabricanteDto(fabricanteDAO.buscarTodos());
	}
}
