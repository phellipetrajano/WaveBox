
package br.com.wavebox.config;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.wavebox.repository.UsuarioRepository;





@Repository
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
		
		
		UsuarioRepository usuario = this.usuarioRepository.getOneByCpf(cpf);
		
		
		if (usuario == null) {
			throw new UsernameNotFoundException("Usuário não encontrado.");
		}
		
	
		return new User(usuario.getUsername(),usuario.getPassword(),true,true,true,true,usuario.getAuthorities());
		
		
		
	}


   

}
