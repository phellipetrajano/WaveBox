package br.com.wavebox.service;

import br.com.wavebox.model.Pedido;
import java.util.List;

public interface PedidoService {
    Pedido criarPedido(Pedido pedido);
    List<Pedido> listarPedidos();
    Pedido buscarPedidoPorId(Long id);
}