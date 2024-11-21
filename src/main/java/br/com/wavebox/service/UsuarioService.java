package br.com.wavebox.service;

import br.com.wavebox.model.Usuario;

import java.util.Optional;

public interface UsuarioService {
    Optional<Usuario> buscarClientePorCpf(String cpf); // Deve estar na interface
    void salvarCliente(Usuario usuario);
    String encodePassword(String rawPassword);
}