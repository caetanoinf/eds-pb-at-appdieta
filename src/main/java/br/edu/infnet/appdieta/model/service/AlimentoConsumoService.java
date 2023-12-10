package br.edu.infnet.appdieta.model.service;

import br.edu.infnet.appdieta.model.domain.AlimentoConsumo;
import br.edu.infnet.appdieta.model.repositories.AlimentoConsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class AlimentoConsumoService {
    @Autowired
    private AlimentoConsumoRepository alimentoConsumoRepository;

    public void incluir(AlimentoConsumo alimento) {
        alimentoConsumoRepository.save(alimento);
    }

    public Collection<AlimentoConsumo> obterAlimentos() {
        return (Collection<AlimentoConsumo>) alimentoConsumoRepository.findAll();
    }

    public AlimentoConsumo obterAlimento(Integer id) {
        return alimentoConsumoRepository.findById(id).orElseThrow();
    }
}
