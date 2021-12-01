package br.com.senior.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
@Service
@Profile("prod")
public class PassowordServiceProd implements PasswordService {
	@Value("${br.com.senior.calculadora.password}")
	String senha;
	
	public boolean verificaSenha( String password) {
	if (password.equals(senha)) {
		return true;
	} else {
		
		return false;
	}
	}

}
