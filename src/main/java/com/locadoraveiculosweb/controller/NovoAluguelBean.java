package com.locadoraveiculosweb.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import com.locadoraveiculosweb.dao.CarroDAO;
import com.locadoraveiculosweb.modelo.Aluguel;
import com.locadoraveiculosweb.modelo.ApoliceSeguro;
import com.locadoraveiculosweb.modelo.Carro;
import com.locadoraveiculosweb.service.CadastroAluguelService;
import com.locadoraveiculosweb.service.NegocioException;
import com.locadoraveiculosweb.util.jsf.FacesUtil;

@Named
@ViewScoped
public class NovoAluguelBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroAluguelService cadastroAluguelService;
	@Inject
	private CarroDAO carroDao;
	
	private Aluguel aluguel;
	private List<Carro> carros;

	@PostConstruct
	public void inicializar(){
		this.limpar();
		this.carros = this.carroDao.buscarTodos();
	}
	
	public void limpar(){
		aluguel = new Aluguel();
		this.aluguel.setApoliceSeguro(new ApoliceSeguro());
	}
	
	public void salvar(){
		try {
			this.cadastroAluguelService.salvar(aluguel);
			FacesUtil.addSuccessMessage("Aluguel Cadastrado com Sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage("Não foi Possível Cadastrar o Aluguel!");
		}
		this.limpar();
	}

	public Aluguel getAluguel() {
		return aluguel;
	}

	public void setAluguel(Aluguel aluguel) {
		this.aluguel = aluguel;
	}

	public List<Carro> getCarros() {
		return carros;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}
}
