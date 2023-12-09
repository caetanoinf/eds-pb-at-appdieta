package br.edu.infnet.appdieta.model.service;

import br.edu.infnet.appdieta.model.domain.Refeicao;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RefeicaoService {
    private Map<Integer, Refeicao> refeicoes = new HashMap<Integer, Refeicao>();

    public void incluir(Refeicao refeicao) {
        refeicoes.put(refeicao.getId(), refeicao);
    }

    public Collection<Refeicao> obterRefeicoes() {
        return refeicoes.values();
    }

    public Refeicao obterRefeicao(Integer id) { return refeicoes.get(id); }
}
