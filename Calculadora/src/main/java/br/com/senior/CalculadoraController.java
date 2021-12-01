package br.com.senior;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.senior.services.PasswordService;

@Controller
@RequestMapping(value = "/calculo")
public class CalculadoraController {
	@Autowired
	private PasswordService passwordService;
	@GetMapping(value = "/add")

	public ResponseEntity<Double> adicao(@RequestParam("num1") Double num1, @RequestParam("num2") Double num2, @RequestParam(value="password", required = false) String password) {
		
		if (passwordService.verificaSenha(password)) {
		Double soma = num1 + num2;
		return ResponseEntity.ok().body(soma);
		}
		else {
			return null;
		}
	}

	@GetMapping(value = "/sub")
	public ResponseEntity<Double> subtracao(@RequestParam("num1") Double num1, @RequestParam("num2") Double num2, @RequestParam(value="password", required = false) String password) {
		
		if (passwordService.verificaSenha(password)) {
		Double subtracao = num1 - num2;
		return ResponseEntity.ok().body(subtracao);
	} 
		else {
			return null;
		}
	}

	@GetMapping(value = "/div")
	public ResponseEntity<Double> divisao(@RequestParam("num1") Double num1, @RequestParam("num2") Double num2, @RequestParam(value="password", required = false) String password) {
		Double divisao = num1 / num2;
		return ResponseEntity.ok().body(divisao);
	}

	@GetMapping(value = "/mult")
	public ResponseEntity<Double> multiplicacao(@RequestParam("num1") Double num1, @RequestParam("num2") Double num2, @RequestParam(value="password", required = false) String password) {
		
		if (passwordService.verificaSenha(password)) {
		Double multiplicacao = num1 * num2;
		return ResponseEntity.ok().body(multiplicacao);
		
	}else {
		return null;
	}
	}

	@GetMapping(value = "/addAll")
	public ResponseEntity<Double> adicaoAll(@RequestParam("num") String valor, @RequestParam(value="password", required = false) String password) {
		
		if (passwordService.verificaSenha(password)) {
		String[] numeros = valor.split(",");

		Double soma = 0.0;

		for (String string : numeros) {
			soma += Double.parseDouble(string);
		}

		return ResponseEntity.ok().body(soma);
		
		}else {
			return null;
		}
	}
		

	@GetMapping(value = "/subAll")
	public ResponseEntity<Double> subtracaoAll(@RequestParam("num") String valor, @RequestParam(value="password", required = false) String password) {
		
		if (passwordService.verificaSenha(password)) {
		String[] numeros = valor.split(",");
		Double subtracao = 0.0;
		subtracao = Double.parseDouble(numeros[0]);

		for (int i = 1; i < numeros.length; i++) {
			Double aux = Double.parseDouble(numeros[i]);
			subtracao -= aux;
		}
		

		return ResponseEntity.ok().body(subtracao);

		}else {
			return null;
			
		}
	}

	@GetMapping(value = "/divAll")
	public ResponseEntity<Double> divAll(@RequestParam("num") String valor, @RequestParam(value="password", required = false) String password) {
		
		if (passwordService.verificaSenha(password)) {
		String[] numeros = valor.split(",");
		Double aux = 0.0;
		aux = Double.parseDouble(numeros[0]);

		for (String string : numeros) {
			if (string.contains("0")) {
				return ResponseEntity.noContent().build();
			}
		}
		try {
			for (int i = 1; i < numeros.length; i++) {
				Double divisao = Double.parseDouble(numeros[i]);
				aux /= divisao;
			}
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok().body(aux);
		
		}else {
			return null;
		}
	}

	@GetMapping(value = "/multAll")
	public ResponseEntity<Double> multAll(@RequestParam("num") String valor, @RequestParam(value="password", required = false) String password) {
		
		if (passwordService.verificaSenha(password)) {
		String[] numeros = valor.split(",");
		Double multiplicacao = 1.0;
		for (String string : numeros) {
			multiplicacao *= Double.parseDouble(string);

		}
		return ResponseEntity.ok().body(multiplicacao);
		
		}else {
			return null;
		}
	}
}
