package com.algaworks.aluguelveiculos.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.aluguelveiculos.modelo.Fabricante;
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
	public void excluir(Fabricante fabricante) {
		Fabricante fabricanteTemp = em.find(Fabricante.class, fabricante.getCodigo());
		
		em.remove(fabricanteTemp);
		em.flush();
	}
	
	@SuppressWarnings("unchecked")
	public List<Fabricante> buscarTodos() {
		return em.createQuery("from Fabricante").getResultList();
	}
	
	public Fabricante buscarPeloCodigo(Long codigo) {
		return em.find(Fabricante.class, codigo);
	}
}
