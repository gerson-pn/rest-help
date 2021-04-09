package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.example.demo.modelo.Perfil;
import com.example.demo.modelo.Usuario;
import com.example.demo.repositorio.UsuarioRepositorio;

@SpringBootApplication
public class RestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}
	
	@Component
	public static class Runner implements ApplicationRunner{

		@Autowired
		UsuarioRepositorio urp;
		
		@Override
		public void run(ApplicationArguments args) throws Exception {
						
			Usuario u1 = new Usuario();
			u1.setNome("Gerson");

			Perfil p = new Perfil();
			p.setNome("programador");
			
			Perfil p2 = new Perfil();
			p2.setNome("front-end");

			u1.getPerfil().add(p);
			u1.getPerfil().add(p2);
			
			p.setUsuario(u1);
			p2.setUsuario(u1);
			
			
			urp.save(u1);
			
		}
		
	}

}
