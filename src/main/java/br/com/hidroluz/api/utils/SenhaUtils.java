package br.com.hidroluz.api.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SenhaUtils {

	public static String gerarBCrypt(String senha) {

		if (senha == null) {
			return senha;
		}

		BCryptPasswordEncoder bCryptEncode = new BCryptPasswordEncoder();
		return bCryptEncode.encode(senha);
	}

	public static boolean senhaValida(String senha, String senhaEncoded) {
		BCryptPasswordEncoder bCryptEncode = new BCryptPasswordEncoder();
		return bCryptEncode.matches(senha, senhaEncoded);
	}

}
