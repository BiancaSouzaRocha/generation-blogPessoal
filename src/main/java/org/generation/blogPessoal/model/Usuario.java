package org.generation.blogPessoal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity 
@Table (name = "tb_usuario") //renomeia a tabela
public class Usuario {
	
	
	 
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	
	@NotBlank
	@Size (min = 2, max=100)
	private String nome; 
	
	@NotBlank
	@Size (min = 5, max=100)
	private String usuario;
	
	@NotBlank
	@Size (min = 5, max=100)
	private String senha;
	
	@OneToMany (mappedBy = "usuario", cascade = CascadeType.ALL)
	@JsonIgnoreProperties ("usuario")
	private List <Postagem> postagem;
	
	
	public Usuario(Long id,  String nome, String usuario, String senha) {
		this.id = id;
		this.nome = nome;
		this.usuario = usuario;
		this.senha = senha;
	}


	public Usuario() {}

	
	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
