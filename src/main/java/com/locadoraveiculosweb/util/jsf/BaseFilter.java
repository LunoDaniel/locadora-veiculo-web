package com.locadoraveiculosweb.util.jsf;

import static org.apache.commons.lang3.ObjectUtils.isEmpty;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@NoArgsConstructor
public abstract class BaseFilter implements Filter {


	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		try {

			HttpServletRequest reqt = (HttpServletRequest) request;
			HttpServletResponse resp = (HttpServletResponse) response;
			HttpSession ses = reqt.getSession(false);

			String reqURI = reqt.getRequestURI();
			
			if (validateRequest(reqURI, ses))
				chain.doFilter(request, response);
			else 
				resp.sendRedirect(reqt.getContextPath() + "/Login.xhtml");
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	@Override
	public void destroy() {

	}
	
	protected abstract boolean validateRequest(String request, HttpSession session);
	
	protected boolean cameFromLogin(String request) {
		return request.indexOf("/Login.xhtml") >= 0;
	}
	
	protected boolean hasAUserInSession(HttpSession session) {
		return (!isEmpty(session) && !isEmpty(session.getAttribute("username")));
	}
	
	protected boolean cameFromValidPage(String request) {
		return request.indexOf("/public/") >= 0;
	}
	
	protected boolean isAValidResource(String request) {
		return request.contains("javax.faces.resource");	
	}

}
