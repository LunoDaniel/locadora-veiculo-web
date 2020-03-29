package com.locadoraveiculosweb.dao;

import static com.locadoraveiculosweb.constants.MessageConstants.ViewMessages.ERRO_AO_EXCLUIR_O_FABRICANTE;
import static com.locadoraveiculosweb.util.messages.MessageUtils.getMessage;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.locadoraveiculosweb.modelo.Fabricante;
import com.locadoraveiculosweb.service.NegocioException;
import com.locadoraveiculosweb.util.jpa.Transactional;


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
			throw new NegocioException(getMessage(ERRO_AO_EXCLUIR_O_FABRICANTE.getDescription(), fabricante.getNome()));
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
