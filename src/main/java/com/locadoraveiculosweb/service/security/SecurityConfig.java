package com.locadoraveiculosweb.service.security;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

public class SecurityConfig {

	protected String encrypt(String plainText, PublicKey secretKey) throws Exception {
		getCipher().init(Cipher.ENCRYPT_MODE, secretKey);
		byte[] encryptedByte = getCipher().doFinal(plainText.getBytes());
		Base64.Encoder encoder = Base64.getEncoder();
		String encryptedText = encoder.encodeToString(encryptedByte);
		return encryptedText;
	}

	protected String decrypt(String encryptedText, PrivateKey secretKey) throws Exception {
		Base64.Decoder decoder = Base64.getDecoder();
		byte[] encryptedTextByte = decoder.decode(encryptedText);
		getCipher().init(Cipher.DECRYPT_MODE, secretKey);
		byte[] decryptedByte = getCipher().doFinal(encryptedTextByte);
		return new String(decryptedByte);
	}

	protected KeyFactory keyFactoryInstance() throws NoSuchAlgorithmException {
		return KeyFactory.getInstance("AES");
	}
	
	public KeyPair keyPairGenerator() throws NoSuchAlgorithmException {

		final KeyPairGenerator keyGen = KeyPairGenerator.getInstance("AES");
		keyGen.initialize(128);
		return keyGen.generateKeyPair();
	}
	
	
	protected PublicKey generatePublicKByString(byte[] publicK) throws InvalidKeySpecException, NoSuchAlgorithmException {
		PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(publicK);
		return keyFactoryInstance().generatePublic(spec);
	}

	protected PrivateKey generatePrivateKByString(byte[] privateKey) throws InvalidKeySpecException, NoSuchAlgorithmException {
		PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(privateKey);
		return keyFactoryInstance().generatePrivate(spec);
	}


	private Cipher getCipher() {
		try {
			return Cipher.getInstance("AES/CBC/PKCS5Padding");
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
		}

		return null;
	}
}
