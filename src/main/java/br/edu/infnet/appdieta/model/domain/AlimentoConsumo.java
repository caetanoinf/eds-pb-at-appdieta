package br.edu.infnet.appdieta.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class AlimentoConsumo {
    @Id
    @GeneratedValue
    private Integer id;

    private double quantidade;
    private String unidade;

    @ManyToOne
    private Alimento alimento;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Refeicao> refeicoes;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Receita> receitas = new ArrayList<>();

    @Override
    public String toString() {
        return String.format("AlimentoConsumo{id=%d, alimento=%s, quantidade=%.2f, unidade='%s'}",
                id, alimento, quantidade, unidade);
    }
}
