package com.example.demo.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
@JsonIgnoreProperties // <-- Veja a explicação na classe perfil
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String nome;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario", fetch = FetchType.EAGER)
	@JsonManagedReference // <-- Mesma explicação da classe perfil. O detalhe aqui é que um ou mais perfis
							// pertence a um usuário. Por isso a anotação de usuario é do tipo Managed,
							// enquanto de perfil é do tipo Back. Isto é assim porque do jeito que fiz
							// usuário é o "pai" dos perfis, ou seja ele que tem a lista com os perfis e não
							// o contrario.
	private List<Perfil> perfis = new ArrayList<>();
}
