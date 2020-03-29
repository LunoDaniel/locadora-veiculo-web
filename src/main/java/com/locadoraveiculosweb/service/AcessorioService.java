package com.locadoraveiculosweb.service;

import static com.locadoraveiculosweb.constants.MessageConstants.BusinessMessages.DESCRICA_OBRIGATORIA;
import static com.locadoraveiculosweb.util.messages.MessageUtils.getMessage;
import static org.apache.commons.lang3.StringUtils.isBlank;

import java.util.List;

import javax.inject.Inject;

import com.locadoraveiculosweb.dao.AcessorioDAO;
import com.locadoraveiculosweb.mappers.AcessorioMapper;
import com.locadoraveiculosweb.modelo.Acessorio;
import com.locadoraveiculosweb.modelo.dtos.AcessorioDto;
import com.locadoraveiculosweb.util.jpa.Transactional;

public class AcessorioService implements Service<AcessorioDto> {

	private static final long serialVersionUID = 1L;

	@Inject
	AcessorioDAO acessorioDao;
	
	@Inject
	AcessorioMapper mapper;

	@Override
	@Transactional
	public AcessorioDto salvar(AcessorioDto acessorioDto) throws NegocioException {

		if (isBlank(acessorioDto.getDescricao())) {
			throw new NegocioException(getMessage(DESCRICA_OBRIGATORIA.getDescription(), Acessorio.class.getSimpleName()));
		}

		Acessorio acessorio = mapper.toAcessorio(acessorioDto);
		return mapper.toAcessorioDto(acessorioDao.salvar(acessorio));
	}

	@Override
	public AcessorioDto buscarPeloCodigo(String id) {
		return mapper.toAcessorioDto(acessorioDao.buscarPeloCodigo(Long.valueOf(id)));
	}

	@Override
	public List<AcessorioDto> buscarTodos() {
		return mapper.toAcessorioDto(acessorioDao.buscarTodos());
	}

	@Override
	public void excluir(AcessorioDto viewObject) throws NegocioException {
		Acessorio acessorio = mapper.toAcessorio(viewObject);
		acessorioDao.excluir(acessorio);
	}

}
