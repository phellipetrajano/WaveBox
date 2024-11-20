package br.com.wavebox.repository;

import br.com.wavebox.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Método para buscar usuário por CPF
    Optional<Usuario> findByCpf(String cpf);
}
