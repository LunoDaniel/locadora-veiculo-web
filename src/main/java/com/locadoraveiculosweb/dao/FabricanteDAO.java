package com.algaworks.aluguelveiculos.dao;

import static com.algaworks.aluguelveiculos.constants.MessageConstants.ERRO_AO_EXCLUIR_O_FABRICANTE;
import static com.algaworks.aluguelveiculos.util.messages.MessageUtils.getMessage;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.aluguelveiculos.modelo.Fabricante;
import com.algaworks.aluguelveiculos.service.NegocioException;
import com.algaworks.aluguelveiculos.util.jpa.Transactional;


public class FabricanteDAO implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	public Fabricante salvar(Fabricante fabricante){
		return em.merge(fabricante);
	}
	
	@Transactional
	public void excluir(Fabricante fabricante) throws NegocioException {
		Fabricante fabricanteTemp = em.find(Fabricante.class, fabricante.getCodigo());
		
		try {
			em.remove(fabricanteTemp);
			em.flush();
		} catch (Exception e) {
			throw new NegocioException(getMessage(ERRO_AO_EXCLUIR_O_FABRICANTE, fabricante.getNome()));
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Fabricante> buscarTodos() {
		return em.createQuery("from Fabricante").getResultList();
	}
	
	public Fabricante buscarPeloCodigo(Long codigo) {
		return em.find(Fabricante.class, codigo);
	}
}
