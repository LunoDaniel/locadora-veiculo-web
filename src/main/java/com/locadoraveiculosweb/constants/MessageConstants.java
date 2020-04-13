package com.locadoraveiculosweb.constants;

import lombok.Getter;

public class MessageConstants {
	
	public enum ViewMessages {
		
		FABRICANTE_SALVO_COM_SUCESSO("Fabricante: {0} Salvo com Sucesso!"),
		FABRICANTE_EXCLUIDO_COM_SUCESSO("Fabricante: {0} excluído com sucesso!"),
		
		ACESSORIO_SALVO_COM_SUCESSO("Acessório: {0} Salvo com sucesso!"),
		ACESSORIO_EXCLUIDO_COM_SUCESSO("Acessório: {0} excluído com Sucesso!"),
		
		MODELO_CARRO_SALVO_COM_SUCESSO("Modelo do Carro: {0} Salvo com Sucesso!"),
		MODELO_CARRO_EXCLUIDO_COM_SUCESSO("Modelo do Carro: {0} excluído com sucesso!"),
		
		CARRO_SALVO_COM_SUCESSO("Carro: {0} Salvo com Sucesso!"),
		CARRO_EXCLUIDO_COM_SUCESSO("Carro: {0} excluído com sucesso!");
		
		@Getter String description;
		ViewMessages(String description) {
			this.description = description;
		}
	}
	
	public enum BusinessMessages {
		
		DESCRICAO_OBRIGATORIA("A Descrição do {0} é Obrigatório!"),
		NOME_OBRIGATORIO("O nome do(a) {0} é Obrigatório(a)"),
		CHASSI_OBRIGATORIO("O Chassi é um campo Obrigatório!"),
		MODELO_CARRO_OBRIGATORIO("O Modelo é um campo Obrigatório!"),
		PLACA_OBRIGATORIO("A Placa é um campo Obrigatório!"),
		COR_OBRIGATORIA("A Cor é um campo Obrigatório!"),
		
		ERRO_AO_EXCLUIR_O_FABRICANTE("Erro ao remover o Fabricante: {0}!"),
		ERRO_AO_EXCLUIR_O_ACESSORIO("Erro ao remover o Acessório: {0}!"),
		ERRO_AO_EXCLUIR_O_MODELO_CARRO("Erro ao remover o Modelo: {0}!"),
		ERRO_AO_EXCLUIR_O_CARRO("Erro ao remover o Carro: {0}!");
		
		@Getter String description;
		BusinessMessages(String description) {
			this.description = description;
		}
	}
}
