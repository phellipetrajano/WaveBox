package br.com.wavebox.controller;

import br.com.wavebox.model.Usuario;
import br.com.wavebox.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String login() {
        return "login"; // Retorna a página login.html
    }

    @GetMapping("/cadastro")
    public String cadastro() {
        return "cadastro"; // Retorna a página cadastro.html
    }

    @PostMapping("/cadastro")
    public String cadastrarUsuario(Usuario usuario, Model model) {
        try {
            usuarioService.salvarCliente(usuario); // Salva o novo usuário
            return "redirect:/login"; // Redireciona para a página de login após o cadastro
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "cadastro"; // Retorna para a página de cadastro em caso de erro
        }
    }
}