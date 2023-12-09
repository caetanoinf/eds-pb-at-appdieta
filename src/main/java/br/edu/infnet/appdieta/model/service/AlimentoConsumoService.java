package br.edu.infnet.appdieta.model.service;

import br.edu.infnet.appdieta.model.domain.AlimentoConsumo;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class AlimentoConsumoService {
    private Map<Integer, AlimentoConsumo> alimentos = new HashMap<Integer, AlimentoConsumo>();

    public void incluir(AlimentoConsumo alimento) {
        alimentos.put(alimento.getId(), alimento);
    }

    public Collection<AlimentoConsumo> obterAlimentos() {
        return alimentos.values();
    }

    public AlimentoConsumo obterAlimento(Integer id) {
        return alimentos.get(id);
    }
}
