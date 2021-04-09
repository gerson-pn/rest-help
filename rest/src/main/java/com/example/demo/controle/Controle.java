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
//		Usuario u1 = new Usuario();
//		u1.setNome("Gerson");
//
//		Perfil p = new Perfil();
//		p.setNome("programador");
//		
//		Perfil p2 = new Perfil();
//		p2.setNome("front-end");
//
//		u1.getPerfil().add(p);
//		u1.getPerfil().add(p2);
//		
//		
//		p.setUsuario(u1);
//		p2.setUsuario(u1);
//		
//		
//		rp.save(u1);

	}

	@PostMapping("/inserir-perfil/")
	public void inserir(Perfil perfil) {
		System.out.println(perfil.getNome());
//		Usuario u1 = rp.getOne(id);
//
//		Perfil p = new Perfil();
//		p.setNome("programador");
//
//		p.setUsuario(u1);
//		u1.setPerfil(p);
//		fp.save(p);

	}

	@GetMapping("/usuarios")
	public List<Usuario> usuarios() {
		return rp.findAll();
	}

	@GetMapping("/perfis")
	public List<Perfil> perfis() {
		return fp.findAll();
	}
}
