package br.com.wavebox.controller;

import br.com.wavebox.model.Usuario;
import br.com.wavebox.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PerfilController {

    private final UsuarioService usuarioService;

    public PerfilController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/perfil")
    public String perfil(String cpf, Model model) {
        Usuario usuario = usuarioService.buscarPorCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o CPF: " + cpf));
        model.addAttribute("usuario", usuario);
        return "perfil";
    }
}
