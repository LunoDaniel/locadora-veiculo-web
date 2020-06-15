package com.locadoraveiculosweb.service;

import static org.apache.commons.lang3.ArrayUtils.toObject;
import static org.apache.commons.lang3.ObjectUtils.isEmpty;

import java.io.Serializable;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

import javax.inject.Inject;

import com.locadoraveiculosweb.dao.SegurancaUsuarioDAO;
import com.locadoraveiculosweb.dao.UsuarioDAO;
import com.locadoraveiculosweb.exception.SegurancaException;
import com.locadoraveiculosweb.modelo.SegurancaUsuario;
import com.locadoraveiculosweb.modelo.Usuario;
import com.locadoraveiculosweb.service.security.PasswordManager;

import lombok.Getter;

public class SegurancaUsuarioService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	SegurancaUsuarioDAO segurancaUsuarioDao;

	@Getter
	@Inject
	UsuarioDAO usuarioDao;

	@Getter
	PasswordManager passwordManager;

	SegurancaUsuarioService() {
		passwordManager = new PasswordManager();
	}

	protected boolean hasCredenciaisUsuario(Usuario usuario, String password) throws SegurancaException {
		SegurancaUsuario segurancaUsuario = segurancaUsuarioDao.buscarPeloCodigoUsuario(usuario.getCodigo());
		byte[] encryptPass = Base64.getDecoder().decode(usuario.getPassword());
		String pass = passwordManager.getDencryptedPass(encryptPass, segurancaUsuario.getPrivateKeyUsuario());

		return !isEmpty(segurancaUsuario) || password.equalsIgnoreCase(pass);

	}

	public Usuario salvarUsuario(Usuario usuario) {
		try {
			KeyPair keys = passwordManager.getKeys();

			byte[] securedPassword = passwordManager.getEncryptedPass(usuario.getPassword(), keys.getPublic());
			usuario.setPassword(Base64.getEncoder().encodeToString(securedPassword));

			usuario = usuarioDao.salvar(usuario);

			salvarUsuarioSeguranca(usuario, keys.getPublic(), keys.getPrivate());

			return usuario;

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return usuario;
	}

	private void salvarUsuarioSeguranca(Usuario usuario, PublicKey publicKey, PrivateKey privateKey) {
		SegurancaUsuario segurancaUsuario = new SegurancaUsuario();

		segurancaUsuario.setPrivateKeyUsuario(toObject(privateKey.getEncoded()));
		segurancaUsuario.setPublicKeyUsusuario(toObject(publicKey.getEncoded()));
		segurancaUsuario.setUsuario(usuario);

		segurancaUsuarioDao.salvar(segurancaUsuario);
	}

}
