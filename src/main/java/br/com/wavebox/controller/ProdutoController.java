package br.com.wavebox.controller;

import br.com.wavebox.model.Produto;
import br.com.wavebox.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public String listarProdutos(Model model) {
        List<Produto> produtos = produtoService.listarProdutos();
        model.addAttribute("produtos", produtos);
        return "produtos"; // Retorna a página produtos.html
    }

    @PostMapping("/cadastrar")
    public String cadastrarProduto(Produto produto) {
        produtoService.cadastrarProduto(produto);
        return "redirect:/produtos"; // Redireciona para a lista de produtos
    }
}