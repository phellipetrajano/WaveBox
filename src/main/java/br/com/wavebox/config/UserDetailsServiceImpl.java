package br.com.wavebox.config;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import br.com.wavebox.repository.UsuarioRepository;
import br.com.wavebox.model.Usuario;

import java.util.Optional;

@Repository
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
    
    @Autowired
    private UsuarioRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
        // Usando o método findByCpf para buscar o usuário
        Optional<Usuario> usuarioOptional = userRepository.findByCpf(cpf);
        
        // Verificando se o usuário existe
        Usuario usuario = usuarioOptional.orElseThrow(() -> 
            new UsernameNotFoundException("Usuário não encontrado.")
        );
        
        // Retornando os detalhes do usuário
        return new User(usuario.getUsername(), usuario.getPassword(), true, true, true, true, usuario.getAuthorities());
    }
}