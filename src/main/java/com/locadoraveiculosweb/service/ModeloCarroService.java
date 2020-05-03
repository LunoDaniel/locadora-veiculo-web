package com.locadoraveiculosweb.service;

import static com.locadoraveiculosweb.constants.MessageConstants.BusinessMessages.DESCRICAO_OBRIGATORIA;
import static com.locadoraveiculosweb.constants.MessageConstants.BusinessMessages.NOME_OBRIGATORIO;
import static com.locadoraveiculosweb.util.messages.MessageUtils.getMessage;
import static java.util.Optional.ofNullable;
import static org.apache.commons.lang3.ObjectUtils.isEmpty;
import static org.apache.commons.lang3.StringUtils.isBlank;

import java.util.List;

import javax.inject.Inject;

import com.locadoraveiculosweb.dao.ModeloCarroDAO;
import com.locadoraveiculosweb.exception.NegocioException;
import com.locadoraveiculosweb.mappers.ModeloCarroMapper;
import com.locadoraveiculosweb.modelo.Categoria;
import com.locadoraveiculosweb.modelo.Fabricante;
import com.locadoraveiculosweb.modelo.ModeloCarro;
import com.locadoraveiculosweb.modelo.dtos.ModeloCarroDto;
import com.locadoraveiculosweb.util.jpa.Transactional;

public class ModeloCarroService implements Service<ModeloCarroDto> {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ModeloCarroDAO modeloCarroDAO;

	@Inject
	private ModeloCarroMapper mapper;

	@Transactional
	public ModeloCarroDto salvar(ModeloCarroDto modeloCarroDto) throws NegocioException {
		
		if(isEmpty(modeloCarroDto.getFabricante())) {
			throw new NegocioException(getMessage(NOME_OBRIGATORIO.getDescription(), Fabricante.class.getSimpleName()));
		}
		
		if(isEmpty(modeloCarroDto.getCategoria())) {
			throw new NegocioException(getMessage(DESCRICAO_OBRIGATORIA.getDescription(), Categoria.class.getSimpleName()));
		}
		
		if(isBlank(modeloCarroDto.getDescricao())) {
			throw new NegocioException(getMessage(DESCRICAO_OBRIGATORIA.getDescription(), ModeloCarro.class.getSimpleName()));
		}
		
		ModeloCarro modeloCarro = mapper.toModeloCarro(ofNullable(modeloCarroDto).orElse(new ModeloCarroDto()));
		modeloCarro = modeloCarroDAO.salvar(modeloCarro);
		
		return mapper.toModeloCarroDto(modeloCarro);
	}

	@Override
	public ModeloCarroDto buscarPeloCodigo(String id) {
		ModeloCarro modeloCarro = this.modeloCarroDAO.buscarPeloCodigo(new Long(id));
		return mapper.toModeloCarroDto(ofNullable(modeloCarro).orElse(null));
	}

	@Override
	public void excluir(ModeloCarroDto viewObject) throws NegocioException {
		ModeloCarro modeloCarro = mapper.toModeloCarro(viewObject);
		modeloCarroDAO.excluir(modeloCarro);
	}

	@Override
	public List<ModeloCarroDto> buscarTodos() {
		return mapper.toModeloCarroDto(modeloCarroDAO.buscarTodos());
	}

}
