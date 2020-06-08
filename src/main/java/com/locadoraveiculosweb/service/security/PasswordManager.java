package com.locadoraveiculosweb.service.security;

import static org.apache.commons.lang3.ArrayUtils.toPrimitive;

public class PasswordManager extends SecurityConfig {
	
	public String getEncryptedPass(String pass, Byte[] publicKey) {
		try {
			return encrypt(pass, generatePublicKByString(toPrimitive(publicKey)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getDencryptedPass(String pass, Byte[] privateKey) {
		try {
			return decrypt(pass, generatePrivateKByString(toPrimitive(privateKey)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}