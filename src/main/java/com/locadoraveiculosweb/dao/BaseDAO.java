package com.locadoraveiculosweb.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.locadoraveiculosweb.modelo.BaseEntity;
import com.locadoraveiculosweb.service.NegocioException;
import com.locadoraveiculosweb.util.jpa.Cache;
import com.locadoraveiculosweb.util.jpa.Transactional;

public abstract class BaseDAO<T extends BaseEntity> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;
	
	@Inject
	Cache<T> cache;
	
	public T salvar(T o) {
		return em.merge(o);
	}

	@Transactional
	public void excluir(T o) throws NegocioException {
		T object = em.find(getEntityClass(), o.getCodigo());

		try {
			em.remove(object);
			em.flush();
		} catch (Exception e) {
			throw new NegocioException(getErroMessage(object));
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> buscarTodos() {
		if(cache.containsKey(getCacheKey())) {
			return (List<T>) cache.getValue(getCacheKey());
		}
		
		List<T> list = em.createNamedQuery(queryForAll(), getEntityClass()).getResultList();
		cache.putValue(getCacheKey(), list);
		
		return list;
	}

	public T buscarPeloCodigo(Long codigo) {
		return em.find(getEntityClass(), codigo);
	}

	protected abstract Class<T> getEntityClass();

	protected abstract String getErroMessage(T object);

	protected abstract String queryForAll();

	protected abstract String getCacheKey();
	
}
