package com.algaworks.curso.jpa2.DAO;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class CarroDAO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	EntityManager em;
	
	@Transactional
	public void excluir(Carro carro) throws NegocioException {
		carro = this.buscarPeloCodigo(carro.getCodigo());
		try {
			em.remove(carro);
			em.flush();
		} catch (PersistenceException e) {
			throw new NegocioException(e.getMessage());
		}
	}
	
	public void salvar(Carro carro){
		em.merge(carro);
	}
	
	public Carro buscarPeloCodigo(Long codigo){
		return em.find(Carro.class, codigo);
	}
	
	@SuppressWarnings("unchecked")
	public List<Carro> buscarTodos(){
		return em.createQuery("from Carro").getResultList();
	}

}
