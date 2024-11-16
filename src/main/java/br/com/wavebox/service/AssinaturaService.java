package br.com.wavebox.service;

import br.com.wavebox.model.Assinatura;
import java.util.List;

public interface AssinaturaService {
    Assinatura criarAssinatura(Assinatura assinatura);
    List<Assinatura> listarAssinaturas();
}