package com.locadoraveiculosweb.constants;

import static java.util.Arrays.stream;

import com.locadoraveiculosweb.service.NegocioException;

import lombok.Getter;

public class MessageConstants {
	
	public enum ViewMessages {
	
		SALVO_COM_SUCESSO("{0}: {1} salvo com Sucesso!", "SALVAR", "SUCESSO"),
		EXCLUIDO_COM_SUCESSO("{0}: {1} excluído com sucesso!", "EXCLUIR", "SUCESSO"),
		
		ERRO_AO_SALVAR("Erro ao salvar o {0}: {1}!", "SALVAR", "ERRO"),
		ERRO_AO_EXCLUIR("Erro ao excluir o {0}: {1}!", "EXCLUIR", "ERRO");
		
		@Getter String description;
		@Getter String msgFor;
		@Getter String type;
		
		ViewMessages(String description, String msgFor, String type) {
			this.description = description;
			this.msgFor = msgFor;
			this.type = type;
		}
		
		public static String getMsgFor(String msgFor, String type) throws NegocioException {
			return stream(ViewMessages.values())
						.filter( vMgF -> msgFor.equals(vMgF.getMsgFor()) )
						.filter( vMgT -> type.equals(vMgT.getType() ))
					.findAny().get().getDescription();
		}
	}
	
	public enum BusinessMessages {
		
		DESCRICAO_OBRIGATORIA("A Descrição do {0} é Obrigatório!"),
		NOME_OBRIGATORIO("O nome do(a) {0} é Obrigatório(a)"),
		CHASSI_OBRIGATORIO("O Chassi é um campo Obrigatório!"),
		MODELO_CARRO_OBRIGATORIO("O Modelo é um campo Obrigatório!"),
		PLACA_OBRIGATORIO("A Placa é um campo Obrigatório!"),
		COR_OBRIGATORIA("A Cor é um campo Obrigatório!");
		
		@Getter String description;
		BusinessMessages(String description) {
			this.description = description;
		}
	}
}
