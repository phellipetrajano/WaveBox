package br.com.wavebox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeController {

    @GetMapping("/") // Método para redirecionar a raiz para /home
    public String redirectToHome() {
        return "redirect:/home"; // Redireciona para a página home
    }

    @GetMapping("/home")
    public String home() {
        return "home"; // Certifique-se de que o arquivo `home.html` existe na pasta `templates`
    }
}