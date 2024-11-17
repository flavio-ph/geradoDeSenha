package com.facs.gerarSenha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GerarSenhaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerarSenhaApplication.class, args);
		olaMundo();
	}

	public static void olaMundo() {
		System.out.println("Ola Mundo");
	}

}
