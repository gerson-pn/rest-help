package com.example.demo.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Perfil;
import com.example.demo.modelo.Usuario;
import com.example.demo.repositorio.PerfilRepositorio;
import com.example.demo.repositorio.UsuarioRepositorio;

@RestController
public class Controle {
	@Autowired
	UsuarioRepositorio rp;
	@Autowired
	PerfilRepositorio fp;

	@GetMapping("/")
	public void start() {
	}

	@PostMapping("/inserir-perfil")
	public void inserir( Perfil perfil) {
		System.out.println(perfil.getNome());

	}

	@GetMapping("/usuarios")
	public List<Usuario> usuarios() {
		List<Usuario> usuarios = rp.findAll();
		return usuarios;
	}

	@GetMapping("/perfis")
	public List<Perfil> perfis() {
		return fp.findAll();
	}
}
