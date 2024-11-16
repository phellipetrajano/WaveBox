package br.com.wavebox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.wavebox.model.Assinatura;

public interface AssinaturaRepository extends JpaRepository<Assinatura, Long> {
}