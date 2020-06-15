package com.locadoraveiculosweb.service.security;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

import javax.crypto.Cipher;

public class SecurityConfig {

	public static final String RSA = "RSA/ECB/OAEPWithSHA1AndMGF1Padding";

	protected static byte[] encrypt(String plainText, PublicKey publicKey) throws Exception {
		Cipher cipher = Cipher.getInstance(RSA);
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		return cipher.doFinal(plainText.getBytes());
	}

	protected static String decrypt(byte[] encryptedText, PrivateKey privateKey) throws Exception {
		Cipher cipher = Cipher.getInstance(RSA);
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		byte[] decryptedByte = cipher.doFinal(encryptedText);
		return new String(decryptedByte);
	}


	public KeyFactory keyFactoryInstance() throws NoSuchAlgorithmException {
		return KeyFactory.getInstance("RSA");
	}

	public KeyPair keyPairGenerator() throws NoSuchAlgorithmException {
		final KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
		keyGen.initialize(1024);
		return keyGen.generateKeyPair();
	}

	protected PublicKey generatePublicKByString(byte[] publicK)
			throws InvalidKeySpecException, NoSuchAlgorithmException {
		PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(publicK);
		return keyFactoryInstance().generatePublic(spec);
	}

	protected PrivateKey generatePrivateKByString(byte[] privateKey)
			throws InvalidKeySpecException, NoSuchAlgorithmException {
		PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(privateKey);
		return keyFactoryInstance().generatePrivate(spec);
	}
}
