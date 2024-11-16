package br.com.wavebox.service;

import br.com.wavebox.model.Produto;

import java.util.List;

public interface ProdutoService {
    Produto cadastrarProduto(Produto produto);
    List<Produto> listarProdutos();
}