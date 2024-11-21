package br.com.wavebox.controller;

import br.com.wavebox.model.Usuario;
import br.com.wavebox.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class PerfilController {

    private final UsuarioService usuarioService;

    public PerfilController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/perfil")
    public String perfil(String cpf, Model model) {
        Optional<Usuario> usuario = usuarioService.buscarClientePorCpf(cpf);
        if (usuario.isPresent()) {
            model.addAttribute("usuario", usuario.get());
        } else {
            throw new RuntimeException("Usuário não encontrado com o CPF: " + cpf);
        }
        return "perfil"; // Retorna a página perfil.html
    }
}