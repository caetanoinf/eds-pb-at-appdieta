package br.edu.infnet.appdieta.model.service;

import br.edu.infnet.appdieta.model.domain.Alimento;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AlimentoService {
    private Map<Integer, Alimento> alimentos = new HashMap<Integer, Alimento>();

    public void incluir(Alimento alimento) {
        alimentos.put(alimento.getId(), alimento);
    }

    public Collection<Alimento> obterAlimentos() {
        return alimentos.values();
    }

    public Alimento obterAlimento(Integer id) {
        return alimentos.get(id);
    }
}
