package org.generation.blogPessoal.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.generation.blogPessoal.model.Usuario;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;


@SpringBootTest (webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance (TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@BeforeAll
	void start () {
		
		usuarioRepository.save(new Usuario (0L, "Lucca Rocha", "lucca@email.com", "1234562"));
		usuarioRepository.save(new Usuario (0L, "Renata Silva", "renata@email.com", "1234562"));
		usuarioRepository.save(new Usuario (0L, "Adriana Rocha", "adriana@email.com", "1234562"));
		usuarioRepository.save(new Usuario (0L, "Mag Rocha", "mag@email.com", "1234562"));
	
	}
	@Test
	@DisplayName ("Retorna um usuário")
	public void deveRetornarUmUsuario () {
		
		Optional <Usuario> usuario = usuarioRepository.findByUsuario("lucca@email.com");
		assertTrue(usuario.get().getUsuario().equals("lucca@email.com"));
	}
	
	@Test
	@DisplayName("Retorna três usuários")
	public void deveRetornarTresUsuarios () {
		
		List <Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase ("Rocha");
		assertEquals(3, listaDeUsuarios.size());
		assertTrue(listaDeUsuarios.get(0).getNome().equals("Lucca Rocha"));
		assertTrue(listaDeUsuarios.get(0).getNome().equals("Adriana Rocha"));
		assertTrue(listaDeUsuarios.get(0).getNome().equals("Mag Rocha")); 
	}
	

}
