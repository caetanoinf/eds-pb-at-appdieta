package br.edu.infnet.appdieta.model.service;

import br.edu.infnet.appdieta.model.domain.Alimento;
import br.edu.infnet.appdieta.model.repositories.AlimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AlimentoService {
    @Autowired
    private AlimentoRepository alimentoRepository;

    public void incluir(Alimento alimento) {
        alimentoRepository.save(alimento);
    }

    public Collection<Alimento> obterAlimentos() {
        return (Collection<Alimento>) alimentoRepository.findAll();
    }

    public Alimento obterAlimento(Integer id) {
        return alimentoRepository.findById(id).orElseThrow();
    }
}
