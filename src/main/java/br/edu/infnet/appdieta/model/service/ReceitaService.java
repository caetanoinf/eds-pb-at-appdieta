package br.edu.infnet.appdieta.model.service;

import br.edu.infnet.appdieta.model.domain.Receita;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ReceitaService {
    private Map<Integer, Receita> receitas = new HashMap<>();

    public void incluir(Receita receita) {
        receitas.put(receita.getId(), receita);
    }

    public Collection<Receita> obterReceitas() {
        return receitas.values();
    }

    public Receita obterReceita(Integer id) {
        return receitas.get(id);
    }
}
