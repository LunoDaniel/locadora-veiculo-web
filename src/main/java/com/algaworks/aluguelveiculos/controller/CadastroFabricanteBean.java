package com.algaworks.aluguelveiculos.controller;

import static com.algaworks.aluguelveiculos.constants.MessageConstants.FABRICANTE_SALVO_COM_SUCESSO;
import static com.algaworks.aluguelveiculos.util.messages.MessageUtils.getMessage;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import com.algaworks.aluguelveiculos.modelo.Fabricante;
import com.algaworks.aluguelveiculos.service.CadastroFabricanteService;
import com.algaworks.aluguelveiculos.service.NegocioException;
import com.algaworks.aluguelveiculos.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroFabricanteBean implements Serializable
{

	

	private static final long serialVersionUID = 1L;
	
	@Inject 
	private CadastroFabricanteService cadastroFabricanteSerivice;
	private Fabricante fabricante;
	
	@PostConstruct
	public void init(){
		this.limpar();
	}
	
	public void limpar(){
		this.setFabricante(new Fabricante());
	}
	
	public void salvar(){
		try 
		{
			Fabricante fabricanteSalvo = cadastroFabricanteSerivice.salvar( fabricante );
			FacesUtil.addSuccessMessage(getMessage(FABRICANTE_SALVO_COM_SUCESSO, fabricanteSalvo.getNome()));
			this.limpar();
			
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	
	public Fabricante getFabricante() {
		return this.fabricante;
	}
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
}
