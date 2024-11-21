package br.com.wavebox.controller;

import br.com.wavebox.model.Usuario;
import br.com.wavebox.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/usuario")
    public String usuario(String cpf, Model model) {
        Optional<Usuario> usuario = usuarioService.buscarClientePorCpf(cpf);
        if (usuario.isPresent()) {
            model.addAttribute("usuario", usuario.get());
        } else {
            throw new RuntimeException("Usuário não encontrado com CPF: " + cpf);
        }
        return "usuario"; // Retorna a página usuario.html
    }
}