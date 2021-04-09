package com.example.demo.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@JsonIgnoreProperties // <-- Esta anotação serve para evitar problemas de conversão caso alguma
						// propriedade do json não venha. Por isso que eu testei sem enviar o id. Isto é
						// muito comum de acontecer, por exemplo num caso de criar um novo usuário, ele
						// so recebe id quando de fato é inserido no banco e quem cria o id dele é o
						// hibernate.
public class Perfil {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String nome;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "usuarioId")
	@JsonBackReference // <-- esta aqui serve para eviar loop infinito na hora de gerar o json, dado
						// que eu fiz uma relação bidirecional entre as entidades. Isto so é necessario
						// se a relação fo bidirecional.
	private Usuario usuario;
}
