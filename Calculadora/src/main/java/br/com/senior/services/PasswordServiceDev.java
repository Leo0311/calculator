package br.com.senior.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class PasswordServiceDev implements PasswordService {

	@Override
	
	public boolean verificaSenha(String password) {
		
		return true;
	}

	
}
