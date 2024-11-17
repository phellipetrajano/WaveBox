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

    /**
     * Salva um novo cliente no banco de dados.
     * @param cliente - O cliente a ser salvo.
     * @return - O cliente salvo.
     */
    public Usuario salvarCliente(Usuario cliente) {
        // Verificando se o cliente já existe com base no CPF
        Optional<Usuario> clienteExistente = UsuarioRepository.findById(cliente.getCpf());
        if (clienteExistente.isPresent()) {
            throw new RuntimeException("Cliente já cadastrado com este CPF.");
        }

        // Caso o cliente não exista, ele será salvo no banco de dados
        return clienteRepository.save(cliente);
    }

    /**
     * Busca um cliente pelo CPF.
     * @param cpf - O CPF do cliente.
     * @return - O cliente encontrado ou um Optional vazio caso não exista.
     */
    public Optional<Usuario> buscarClientePorCpf(String cpf) {
        return clienteRepository.findById(cpf);  // Busca o cliente no banco de dados
    }

    /**
     * Deleta um cliente pelo CPF.
     * @param cpf - O CPF do cliente a ser deletado.
     */
    public void deletarCliente(String cpf) {
        // Verificando se o cliente existe antes de tentar deletar
        Optional<Usuario> clienteExistente = buscarClientePorCpf(cpf);
        
        if (clienteExistente.isEmpty()) {
            throw new RuntimeException("Cliente não encontrado para deletar.");
        }
        
        UsuarioRepository.deleteById(cpf);  // Deleta o cliente pelo CPF
    }

    /**
     * Atualiza as informações de um cliente.
     * @param cpf - O CPF do cliente a ser atualizado.
     * @param clienteAtualizado - O cliente com os dados atualizados.
     * @return - O cliente atualizado.
     */
    public Usuario atualizarCliente(String cpf, Usuario clienteAtualizado) {
        // Verificando se o cliente existe antes de tentar atualizar
        Optional<Usuario> clienteExistente = buscarClientePorCpf(cpf);

        if (clienteExistente.isEmpty()) {
            throw new RuntimeException("Cliente não encontrado para atualizar.");
        }

        // Recuperando o cliente existente
        Usuario usuario = clienteExistente.get();

        // Atualizando os dados do cliente
        usuario.setNome(clienteAtualizado.getNome());
        usuario.setEmail(clienteAtualizado.getEmail());
        usuario.setEndereco(clienteAtualizado.getEndereco());
        usuario.setTelefone(clienteAtualizado.getTelefone());

        // Salvando o cliente com as novas informações
        return UsuarioRepository.save(usuario);
    }
}