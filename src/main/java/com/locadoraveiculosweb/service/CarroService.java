package com.locadoraveiculosweb.service;

import static com.locadoraveiculosweb.constants.MessageConstants.BusinessMessages.CHASSI_OBRIGATORIO;
import static com.locadoraveiculosweb.constants.MessageConstants.BusinessMessages.COR_OBRIGATORIA;
import static com.locadoraveiculosweb.constants.MessageConstants.BusinessMessages.MODELO_CARRO_OBRIGATORIO;
import static com.locadoraveiculosweb.constants.MessageConstants.BusinessMessages.PLACA_OBRIGATORIO;
import static java.lang.Long.valueOf;
import static org.apache.commons.lang3.ObjectUtils.isEmpty;
import static org.apache.commons.lang3.StringUtils.isBlank;

import java.util.List;

import javax.inject.Inject;

import com.locadoraveiculosweb.dao.CarroDAO;
import com.locadoraveiculosweb.exception.NegocioException;
import com.locadoraveiculosweb.mappers.CarroMapper;
import com.locadoraveiculosweb.modelo.Carro;
import com.locadoraveiculosweb.modelo.dtos.CarroDto;
import com.locadoraveiculosweb.util.jpa.Transactional;

public class CarroService implements Service<CarroDto> {
	private static final long serialVersionUID = 1L;

	@Inject
	private CarroDAO carroDao;
	
	@Inject
	private CarroMapper mapper;

	@Override
	@Transactional
	public CarroDto salvar(CarroDto carroDto) throws NegocioException {
		
		if(isBlank(carroDto.getChassi())){
			throw new NegocioException(CHASSI_OBRIGATORIO.getDescription());
		}
		
		if(isEmpty(carroDto)){
			throw new NegocioException(MODELO_CARRO_OBRIGATORIO.getDescription());
		}
		
		if(isBlank(carroDto.getPlaca())){
			throw new NegocioException(PLACA_OBRIGATORIO.getDescription());
		}
		
		if(isBlank(carroDto.getCor())){
			throw new NegocioException(COR_OBRIGATORIA.getDescription());
		}
		
		Carro carro = mapper.toCarro(carroDto);
		
		return mapper.toCarroDto(this.carroDao.salvar(carro));
	}

	@Override
	public CarroDto buscarPeloCodigo(String id) {
		return mapper.toCarroDto(carroDao.buscarPeloCodigo(valueOf(id)));
	}

	@Override
	public void excluir(CarroDto viewObject) throws NegocioException {
		carroDao.excluir(mapper.toCarro(viewObject));
	}

	@Override
	public List<CarroDto> buscarTodos() {
		return mapper.toCarroDto(carroDao.buscarTodos());
	}
	
	public CarroDto buscarCarroComAcessorios(Long id) {
		return mapper.toCarroDto(carroDao.buscarCarroComAcessorios(id));
	}

}
