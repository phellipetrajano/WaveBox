package br.com.wavebox.service;

import br.com.wavebox.model.Usuario;
import br.com.wavebox.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceimpl {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvarCliente(Usuario usuario) {
        // Verificando se o usuário já existe com base no CPF
        Optional<Usuario> usuarioExistente = usuarioRepository.findByCpf(usuario.getCpf());
        if (usuarioExistente.isPresent()) {
            throw new RuntimeException("Usuário já cadastrado com este CPF.");
        }

        // Caso o usuário não exista, ele será salvo no banco de dados
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> buscarClientePorCpf(String cpf) {
        return usuarioRepository.findByCpf(cpf);  // Busca o usuário no banco de dados
    }
}