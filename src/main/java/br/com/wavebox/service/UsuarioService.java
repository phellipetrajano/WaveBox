package br.com.wavebox.service;

import br.com.wavebox.model.Usuario;
import java.util.List;

public interface UsuarioService {
    Usuario cadastrarUsuario(Usuario usuario);
    Usuario buscarUsuarioPorEmail(String email);
    List<Usuario> listarUsuarios();
}