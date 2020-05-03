package com.locadoraveiculosweb.dao;

import static org.apache.commons.lang3.ObjectUtils.isEmpty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.locadoraveiculosweb.exception.NegocioException;
import com.locadoraveiculosweb.modelo.BaseEntity;
import com.locadoraveiculosweb.util.jpa.Cache;
import com.locadoraveiculosweb.util.jpa.Transactional;

import lombok.Getter;

public abstract class BaseDAO<T extends BaseEntity> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Getter
	@Inject
	private EntityManager em;
	
	@Inject
	Cache<T> cache;
	
	public T salvar(T o) {
		
		if(!isEmpty(o.getCodigo())) {
			o.setDataAlteracao(new Date());
		}
		
		o = em.merge(o);
		cache.updateValue(o, getCacheKey());
		return o;
	}

	@Transactional
	public void excluir(T o) throws NegocioException {
		T object = null;
		try {
			object = em.find(getEntityClass(), o.getCodigo());
			em.remove(object);
			cache.removeValue(object, getCacheKey());
			em.flush();
		} catch (Exception e) {
			throw new NegocioException();
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> buscarTodos() {
		if(cache.isInCache(getCacheKey())) {
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

	protected abstract String queryForAll();

	protected abstract String getCacheKey();
	
}
