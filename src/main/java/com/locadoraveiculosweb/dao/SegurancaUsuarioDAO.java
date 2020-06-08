package com.locadoraveiculosweb.dao;

import com.locadoraveiculosweb.modelo.SegurancaUsuario;

public class SegurancaUsuarioDAO extends BaseDAO<SegurancaUsuario>{

	private static final long serialVersionUID = 1L;

	@Override
	protected Class<SegurancaUsuario> getEntityClass() {
		return SegurancaUsuario.class;
	}

	@Override
	protected String queryForAll() {
		return "SegurancaUsuario.FindAll";
	}

	@Override
	protected String getCacheKey() {
		return "segurancaUsuarioCache";
	}
	
	public SegurancaUsuario buscarPeloCodigoUsuario(Long codigoUsuario) {
		return getEm().createNamedQuery("SegurancaUsuario.findByCodigoUsuario", SegurancaUsuario.class)
						.setParameter("codigoUsuario", codigoUsuario).getSingleResult();
	}

}
