package br.com.wavebox.repository;

import br.com.wavebox.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Método para buscar o usuário pelo nome de usuário
	Usuario getOneByCpf(String cpf);

}