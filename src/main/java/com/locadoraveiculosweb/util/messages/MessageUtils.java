package com.algaworks.aluguelveiculos.util.messages;

import static java.text.MessageFormat.format;

public class MessageUtils {
	
	MessageUtils() {}
	
	public static String getMessage(String message, Object...params) {
		return format(message, params);
	}

}
