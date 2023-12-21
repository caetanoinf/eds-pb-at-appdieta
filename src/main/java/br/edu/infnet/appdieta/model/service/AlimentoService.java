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

    public List<Alimento> obterAlimentos() {
        return (List<Alimento>) alimentoRepository.findAll();
    }

    public Alimento obterAlimento(Integer id) {
        return alimentoRepository.findById(id).orElseThrow();
    }

    public void excluir(Integer id) {
        Alimento alimento = alimentoRepository.findById(id).orElseThrow();
        alimento.getTabelaNutricional().setAlimento(null);
        alimento.getConsumos().forEach(consumo -> consumo.setAlimento(null));
        alimentoRepository.save(alimento);
        alimentoRepository.deleteById(id);
    }
}
