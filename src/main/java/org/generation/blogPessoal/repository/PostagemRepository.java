package org.generation.blogPessoal.repository;

// camada repository responsavel pela comunicação com o banco de dados;

import java.util.List;

import org.generation.blogPessoal.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  //indica para o spring que está classe é um repositório
public interface PostagemRepository extends JpaRepository <Postagem,Long> {
	

	public List <Postagem> findAllByTituloContainingIgnoreCase (String titulo);  // busque todos pelo titulo + tudo que tiver dentro do parametro + não levar em consideração maisculo e minusculo 
}


