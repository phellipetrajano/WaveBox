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
        return "login"; // Nome do template HTML para a página de login
    }

    @GetMapping("/cadastro") // Rota para a página de cadastro
    public String cadastroPage() {
        return "cadastro"; // Nome do template HTML para a página de cadastro
    }

    @PostMapping("/cadastro")
    public String handleCadastro(@ModelAttribute Usuario usuario) {
        try {
            String encodedPassword = usuarioService.encodePassword(usuario.getPassword());
            usuario.setPassword(encodedPassword);
            usuarioService.salvarCliente(usuario);
            return "redirect:/login";
        } catch (Exception e) {
            e.printStackTrace(); // Loga a exceção no console
            return "cadastro"; // Retorna à página de cadastro em caso de erro
        }
    }}