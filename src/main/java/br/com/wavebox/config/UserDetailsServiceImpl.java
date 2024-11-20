package br.com.wavebox.config;

import br.com.wavebox.model.Usuario;
import br.com.wavebox.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public UserDetailsServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByCpf(cpf)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com o CPF: " + cpf));

        return User.builder()
                .username(usuario.getCpf()) // O CPF é usado como o nome de usuário
                .password(usuario.getPassword()) // A senha já deve estar criptografada no banco
                .roles("USER") // Ajuste de acordo com as roles disponíveis
                .build();
    }
}
