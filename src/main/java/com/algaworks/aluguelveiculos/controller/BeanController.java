package com.algaworks.aluguelveiculos.controller;

import javax.annotation.PostConstruct;

import com.algaworks.aluguelveiculos.constants.LabelConstants;

public abstract class BeanController {
	
	@PostConstruct
	public abstract void initializer();
	
	public String getPageTitle(String label) {
		return LabelConstants.valueOf(label).getValue();
	}

}
