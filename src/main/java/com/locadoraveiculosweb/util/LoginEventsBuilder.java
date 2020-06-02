package com.locadoraveiculosweb.util;

import static com.locadoraveiculosweb.modelo.LoginStatusEnum.LOGIN_ERROR;
import static com.locadoraveiculosweb.modelo.LoginStatusEnum.LOGIN_SUCESS;

import com.locadoraveiculosweb.modelo.LoginEvents;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LoginEventsBuilder {
	
	public static LoginEvents create(String username, Boolean success) {
		if(success) {
			return LoginEvents.builder().username(username).status(LOGIN_SUCESS).build();
		}
		
		return LoginEvents.builder().username(username).status(LOGIN_ERROR).build();
	}

}
