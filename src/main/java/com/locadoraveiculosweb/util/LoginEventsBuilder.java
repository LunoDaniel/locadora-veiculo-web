package com.locadoraveiculosweb.util;

import com.locadoraveiculosweb.modelo.LoginEvents;
import com.locadoraveiculosweb.modelo.LoginStatusEnum;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LoginEventsBuilder {

	public static LoginEvents create(String username, LoginStatusEnum status) {
		LoginEvents events = new LoginEvents();
		events.setUsername(username);
		events.setStatus(status);
		return events;
	}

}
