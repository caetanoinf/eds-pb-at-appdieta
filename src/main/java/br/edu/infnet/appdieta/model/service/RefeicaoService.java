package br.edu.infnet.appdieta.model.service;

import br.edu.infnet.appdieta.model.domain.Refeicao;
import br.edu.infnet.appdieta.model.repositories.RefeicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RefeicaoService {
    @Autowired
    private RefeicaoRepository refeicaoRepository;

    public void incluir(Refeicao refeicao) {
        refeicaoRepository.save(refeicao);
    }

    public Collection<Refeicao> obterRefeicoes() {
        return (Collection<Refeicao>) refeicaoRepository.findAll();
    }

    public Refeicao obterRefeicao(Integer id) { return refeicaoRepository.findById(id).orElseThrow(); }
}
