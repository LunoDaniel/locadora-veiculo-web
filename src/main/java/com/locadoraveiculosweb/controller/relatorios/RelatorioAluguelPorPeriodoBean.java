package com.locadoraveiculosweb.controller.relatorios;

import static com.locadoraveiculosweb.constants.LabelConstants.valueOf;
import static org.apache.commons.lang3.ObjectUtils.isEmpty;

import java.util.Date;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

import com.locadoraveiculosweb.modelo.dtos.AluguelDto;
import com.locadoraveiculosweb.service.RelatoriosAlguelService;

import lombok.Getter;
import lombok.Setter;

@Named
@ManagedBean
public class RelatorioAluguelPorPeriodoBean {
	
	
	@Getter @Setter
	Date data;
	
	@Inject
	RelatoriosAlguelService relatorioAluguelService;
	
	List<AluguelDto> relatorio() {
		if(!isEmpty(data))
			return relatorioAluguelService.relatorioAluguelDesde(data);
		return null;
	}
	
	public String getPageTitle(String label) {
		return valueOf(label).getValue();
	}


}
