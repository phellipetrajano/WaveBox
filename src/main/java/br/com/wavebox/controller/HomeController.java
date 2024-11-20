package br.com.wavebox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "home"; // Certifique-se de que o arquivo `home.html` existe na pasta `templates`
    }
}
