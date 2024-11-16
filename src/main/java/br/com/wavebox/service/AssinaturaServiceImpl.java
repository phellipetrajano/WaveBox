package br.com.wavebox.service;

import br.com.wavebox.model.Assinatura;
import br.com.wavebox.repository.AssinaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssinaturaServiceImpl implements AssinaturaService {
    
    @Autowired
    private AssinaturaRepository assinaturaRepository;

    @Override
    public Assinatura criarAssinatura(Assinatura assinatura) {
        return assinaturaRepository.save(assinatura);
    }

    @Override
    public List<Assinatura> listarAssinaturas() {
        return assinaturaRepository.findAll();
    }
}