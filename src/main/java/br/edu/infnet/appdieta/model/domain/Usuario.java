package br.edu.infnet.appdieta.model.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Usuario {
    private Integer id;
    private String nome;
    private String email;

    private PlanoAlimentar planoAlimentar;
    private MetaConsumo metaConsumo;

    private List<Peso> historicoPeso;
    private List<Refeicao> refeicoes;
    private List<Receita> receitas;

    public Usuario() {
        historicoPeso = new ArrayList<Peso>();
        refeicoes = new ArrayList<Refeicao>();
        receitas = new ArrayList<Receita>();
    }

    public void adicionarPeso(Peso peso) {
        historicoPeso.add(peso);
    }

    public void adicionarRefeicao(Refeicao refeicao) {
        refeicoes.add(refeicao);
    }

    public void adicionarReceita(Receita receita) {
        receitas.add(receita);
    }

    @Override
    public String toString() {
        return String.format("Usuario{id=%d, nome='%s', email='%s', planoAlimentar=%s, metaConsumo=%s, historicoPeso=%s, refeicoes=%s, receitas=%s}",
                id, nome, email, planoAlimentar, metaConsumo, historicoPeso, refeicoes, receitas);
    }
}
