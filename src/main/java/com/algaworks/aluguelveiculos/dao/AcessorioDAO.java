package com.algaworks.aluguelveiculos.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.algaworks.aluguelveiculos.modelo.Acessorio;
import com.algaworks.aluguelveiculos.service.NegocioException;
import com.algaworks.aluguelveiculos.util.jpa.Transactional;

public class AcessorioDAO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	EntityManager em;
	
	@Transactional
	public void salvar(Acessorio acessorio){
		em.merge(acessorio);
	}
	
	@SuppressWarnings("unchecked")
	public List<Acessorio> buscarTodos(){
		return em.createQuery("from Acessorio").getResultList();
	}
	
	public Acessorio buscarPeloCodigo(Long codigo){
		return em.find(Acessorio.class, codigo);
	}
	
	@Transactional
	public void excluir(Acessorio acessorio) throws NegocioException{
		acessorio = this.buscarPeloCodigo(acessorio.getCodigo());		
		try {
			em.remove(acessorio);
			em.flush();
		} catch (PersistenceException e) {
			throw new NegocioException(e.getMessage());
		}
	}
}
