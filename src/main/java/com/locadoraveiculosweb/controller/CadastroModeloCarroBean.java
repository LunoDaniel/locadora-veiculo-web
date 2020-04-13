package com.locadoraveiculosweb.controller;

import static com.locadoraveiculosweb.constants.MessageConstants.ViewMessages.MODELO_CARRO_SALVO_COM_SUCESSO;
import static com.locadoraveiculosweb.modelo.Categoria.values;
import static com.locadoraveiculosweb.util.messages.MessageUtils.getMessage;
import static java.util.Arrays.asList;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import com.locadoraveiculosweb.modelo.Categoria;
import com.locadoraveiculosweb.modelo.dtos.FabricanteDto;
import com.locadoraveiculosweb.modelo.dtos.ModeloCarroDto;
import com.locadoraveiculosweb.service.FabricanteService;
import com.locadoraveiculosweb.service.ModeloCarroService;
import com.locadoraveiculosweb.service.Service;

import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class CadastroModeloCarroBean extends BaseController<ModeloCarroDto> {
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	private ModeloCarroDto modeloCarro;
	
	@Getter @Setter
	private List<FabricanteDto> fabricantes;
	
	@Getter @Setter
	private List<Categoria> categorias;
	
	@Inject
	private ModeloCarroService modeloCarroService;
	
	@Inject
	private FabricanteService fabricanteService;

	@Override
	@PostConstruct
	public void initializer() {
		clean();
		this.setFabricantes(fabricanteService.buscarTodos());
		this.categorias = asList(values());
	}

	@Override
	protected void clean() {
		this.modeloCarro = new ModeloCarroDto();
	}

	@Override
	protected Service<ModeloCarroDto> getService() {
		return modeloCarroService;
	}

	@Override
	protected ModeloCarroDto getViewObject() {
		return modeloCarro;
	}

	@Override
	protected String getSuccessMessage(ModeloCarroDto modeloCarro) {
		return getMessage(MODELO_CARRO_SALVO_COM_SUCESSO.getDescription(), modeloCarro.getDescricao());
	}
}
