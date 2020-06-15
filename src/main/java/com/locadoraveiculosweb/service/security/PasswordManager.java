package com.locadoraveiculosweb.service.security;

import static org.apache.commons.lang3.ArrayUtils.toPrimitive;

import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

public class PasswordManager extends SecurityConfig {

	public byte[] getEncryptedPass(String pass, Byte[] publicKey) {
		try {
			return encrypt(pass, generatePublicKByString(toPrimitive(publicKey)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getDencryptedPass(byte[] pass, Byte[] privateKey) {
		try {
			return decrypt(pass, generatePrivateKByString(toPrimitive(privateKey)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public byte[] getEncryptedPass(String pass, PublicKey publicKey) {
		try {
			return encrypt(pass, publicKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getDencryptedPass(byte[] pass, PrivateKey privateKey) {
		try {
			return decrypt(pass, privateKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public KeyPair getKeys() throws NoSuchAlgorithmException {
		return keyPairGenerator();
	}


}