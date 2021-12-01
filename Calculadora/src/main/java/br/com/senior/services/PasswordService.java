package br.com.senior.services;

import org.springframework.stereotype.Service;

@Service
public interface PasswordService {
	
	
	
	public boolean verificaSenha(String password);
}
