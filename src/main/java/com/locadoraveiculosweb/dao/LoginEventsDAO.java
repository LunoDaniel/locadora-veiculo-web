package com.locadoraveiculosweb.dao;

import com.locadoraveiculosweb.modelo.LoginEvents;

public class LoginEventsDAO extends BaseDAO<LoginEvents>{

	private static final long serialVersionUID = 1L;

	@Override
	protected Class<LoginEvents> getEntityClass() {
		return LoginEvents.class;
	}

	@Override
	protected String queryForAll() {
		return null;
	}

	@Override
	protected String getCacheKey() {
		return null;
	}

}
