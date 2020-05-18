package com.locadoraveiculosweb.dao;

import com.locadoraveiculosweb.modelo.Usuario;

public class UsuarioDAO extends BaseDAO<Usuario>{

	private static final long serialVersionUID = 1L;

	@Override
	protected Class<Usuario> getEntityClass() {
		return Usuario.class;
	}

	@Override
	protected String queryForAll() {
		return "Usuario.FindAll";
	}

	@Override
	protected String getCacheKey() {
		return "usuarioCache";
	}
	
	public Usuario findUsuarioByUsername(String username, String password) {
		return getEm().createNamedQuery("Usuario.FindOneByUsernameAndPass", Usuario.class)
				.setParameter("username", username)
				.setParameter("password", password)
				.getSingleResult();
	}

}
