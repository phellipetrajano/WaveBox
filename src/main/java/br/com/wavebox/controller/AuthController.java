package br.com.wavebox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.wavebox.model.Usuario;
import br.com.wavebox.service.UsuarioService;

@Controller
@RequestMapping
public class AuthController {

    private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Nome do template HTML
    }

    @GetMapping("/signup")
    public String signupPage() {
        return "signup"; // Nome do template HTML
    }

    @PostMapping("/signup")
    public String handleSignup(@ModelAttribute Usuario usuario) {
        String encodedPassword = usuarioService.encodePassword(usuario.getPassword());
        usuario.setPassword(encodedPassword);
        usuarioService.salvarCliente(usuario); // Salva o cliente com a senha criptografada
        return "redirect:/login"; // Redireciona para o login após cadastro
    }
}
