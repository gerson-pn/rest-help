package com.example.demo.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@PostMapping("/inserir-usuario")
	public void inserirUsuario(@RequestBody Usuario usuario) {
		System.out.println(usuario.getId()); // <-- id é nulo porque eu não passei ele no json, de propósito.
		System.out.println(usuario.getNome()); // <-- nome vem no json

		for (Perfil p : usuario.getPerfis()) {
			System.out.println(p.getNome()); // <-- aqui verifico se todos os perfis passados no json estão chegando
												// corretamente
		}

		usuario.setId(0l); // <-- como o id vem nulo, se voce sem tentar salvar assim o hibernate vai gerar
							// um excessão. Para corrigir isto, eu coloquei ele como zero que é o valor
							// defaul de um variável do tipo long e não afeta o banco que começa a partir de
							// 1. Assim o hibernate calcula o id certinho.
		rp.save(usuario); // <-- salvando o novo usuário no banco de dados.

	}

	@PostMapping("/inserir-perfil")
	public void inserirPerfil(@RequestBody Perfil perfil) {
		System.out.println(perfil.getNome()); // <-- rest pré-engatilhado para o perfil

	}

	@GetMapping("/usuarios")
	public List<Usuario> usuarios() {
		List<Usuario> usuarios = rp.findAll(); //<-- devolução da lista de usuários.
		return usuarios;
	}

	@GetMapping("/perfis")
	public List<Perfil> perfis() {
		return fp.findAll(); //<-- devolução da lista de perfis
	}
}
