package br.com.wavebox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home"; // Retorna a página home.html
    }

    @GetMapping("/home")
    public String homes() {
        return "home"; // Retorna a página home.html
    }
}