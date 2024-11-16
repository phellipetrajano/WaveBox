package br.com.wavebox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.wavebox.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}