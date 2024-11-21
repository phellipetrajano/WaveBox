package br.com.wavebox.service;

import br.com.wavebox.model.Usuario;
import br.com.wavebox.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceimpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // Certifique-se de que o PasswordEncoder está sendo injetado

    @Override
    public Optional<Usuario> buscarClientePorCpf(String cpf) {
        return usuarioRepository.findByCpf(cpf); // Busca o usuário no banco de dados
    }

    @Override
    public void salvarCliente(Usuario usuario) {
        // Verificando se o usuário já existe com base no CPF
        Optional<Usuario> usuarioExistente = usuarioRepository.findByCpf(usuario.getCpf());
        if (usuarioExistente.isPresent()) {
            throw new RuntimeException("Usuário já cadastrado com este CPF.");
        }

        // Caso o usuário não exista, ele será salvo no banco de dados
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha())); // Codifica a senha antes de salvar
        usuarioRepository.save(usuario);
    }

    @Override
    public String encodePassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword); // Método para codificar a senha
    }
}