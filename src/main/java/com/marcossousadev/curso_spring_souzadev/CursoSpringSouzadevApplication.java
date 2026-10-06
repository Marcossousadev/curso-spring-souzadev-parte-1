package com.marcossousadev.curso_spring_souzadev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// classe iniciadora
// não precisamos configurar tudo do zero
// faz a configuração automatica de Beans
// faz o scaneamento dos componentes para realizar a injeção de dependências
@SpringBootApplication
public class CursoSpringSouzadevApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursoSpringSouzadevApplication.class, args);
	}

}
