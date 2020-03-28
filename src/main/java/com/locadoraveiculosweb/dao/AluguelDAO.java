package com.algaworks.aluguelveiculos.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.algaworks.aluguelveiculos.modelo.Aluguel;
import com.algaworks.aluguelveiculos.service.NegocioException;
import com.algaworks.aluguelveiculos.util.jpa.Transactional;

public class AluguelDAO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	EntityManager em;
	
	@Transactional
	public void excluir(Aluguel aluguel) throws NegocioException {
		aluguel = this.buscarPeloCodigo(aluguel.getCodigo());
		try {
			em.remove(aluguel);
			em.flush();
		} catch (PersistenceException e) {
			throw new NegocioException(e.getMessage());
		}
	}
	
	public void salvar(Aluguel aluguel){
		em.merge(aluguel);
	}
	
	public Aluguel buscarPeloCodigo(Long codigo){
		return em.find(Aluguel.class, codigo);
	}
	
	@SuppressWarnings("unchecked")
	public List<Aluguel> buscarTodos(){
		return em.createQuery("from Aluguel").getResultList();
	}

}
