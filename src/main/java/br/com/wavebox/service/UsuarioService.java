package br.com.wavebox.service;

import br.com.wavebox.model.Usuario;
import br.com.wavebox.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository clienteRepository;

    public Usuario salvarCliente(Usuario cliente) {
        // Verificando se o cliente já existe com base no CPF
        Optional<Usuario> clienteExistente = clienteRepository.findByCpf(cliente.getCpf());
        if (clienteExistente.isPresent()) {
            throw new RuntimeException("Cliente já cadastrado com este CPF.");
        }

        // Caso o cliente não exista, ele será salvo no banco de dados
        return clienteRepository.save(cliente);
    }

    public Optional<Usuario> buscarClientePorCpf(String cpf) {
        return clienteRepository.findByCpf(cpf);  // Busca o cliente no banco de dados
    }

    // Outros métodos (deletar, atualizar) podem ser adicionados conforme necessário
}