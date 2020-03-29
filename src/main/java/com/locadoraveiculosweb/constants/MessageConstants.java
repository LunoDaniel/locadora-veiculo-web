package com.locadoraveiculosweb.constants;

import lombok.Getter;

public class MessageConstants {
	
	public enum ViewMessages {
		
		FABRICANTE_SALVO_COM_SUCESSO("Fabricante: {0} Salvo com Sucesso!"),
		FABRICANTE_EXCLUIDO_COM_SUCESSO("Fabricante: {0} excluído com sucesso!"),
		ERRO_AO_EXCLUIR_O_FABRICANTE("Erro ao remover o Fabricante: {0}!"),
		ACESSORIO_SALVO_COM_SUCESSO("Acessório: {0} Salvo com sucesso!"),
		ACESSORIO_EXCLUIDO_COM_SUCESSO("Acessório: {0} excluído com Sucesso!");
		
		@Getter String description;
		ViewMessages(String description) {
			this.description = description;
		}
	}
	
	public enum BusinessMessages {
		
		DESCRICA_OBRIGATORIA("A Descrição do {0} é Obrigatório!"),
		NOME_OBRIGATORIO("O nome do(a) {0} é Obrigatório(a)");
		
		@Getter String description;
		BusinessMessages(String description) {
			this.description = description;
		}
	}
}
