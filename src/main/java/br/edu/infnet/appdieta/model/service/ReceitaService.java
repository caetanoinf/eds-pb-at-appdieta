package br.edu.infnet.appdieta.model.service;

import br.edu.infnet.appdieta.model.domain.Receita;
import br.edu.infnet.appdieta.model.repositories.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ReceitaService {
    @Autowired
    private ReceitaRepository receitaRepository;

    public void incluir(Receita receita) {
        receitaRepository.save(receita);
    }

    public Collection<Receita> obterReceitas() {
        return (Collection<Receita>) receitaRepository.findAll();
    }

    public Receita obterReceita(Integer id) {
        return receitaRepository.findById(id).orElseThrow();
    }

    public void excluir(Integer id) {
        Receita receita = receitaRepository.findById(id).orElseThrow();
        receita.getAlimentos().forEach(ingrediente -> ingrediente.setReceitas(null));
        receita.setUsuario(null);
        receitaRepository.save(receita);
        receitaRepository.delete(receita);
    }
}
