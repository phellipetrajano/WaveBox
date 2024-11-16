package br.com.wavebox.repository;

import br.com.wavebox.model.Usuario;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.GrantedAuthority;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username); // Método para buscar usuário pelo nome
    Usuario findByCpf(String cpf); // Método para buscar usuário pelo CPF
	String getUsername();
	Collection<? extends GrantedAuthority> getAuthorities();
	String getPassword();
	UsuarioRepository getOneByCpf(String cpf);
}