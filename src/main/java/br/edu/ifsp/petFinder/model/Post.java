package br.edu.ifsp.petFinder.model;

import javax.persistence.*;

@Entity
@Table(name = "tutorials")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "image_url")
	private String image_url;

	@Column(name = "encontrado")
	private boolean encontrado;

	public Post() {

	}
}