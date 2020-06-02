package com.locadoraveiculosweb.util.jsf;

import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "AuthFilter", urlPatterns = { "*.xhtml" })
public class AuthorizationFilter extends BaseFilter {

	@Override
	protected boolean validateRequest(String request, HttpSession session) {
		return cameFromLogin(request) || hasAUserInSession(session) ||cameFromValidPage(request) ||  isAValidResource(request) ;
	}
	
	
} 