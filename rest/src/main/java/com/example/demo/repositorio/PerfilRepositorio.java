package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.Perfil;

public interface PerfilRepositorio extends JpaRepository<Perfil, Long> {

}
