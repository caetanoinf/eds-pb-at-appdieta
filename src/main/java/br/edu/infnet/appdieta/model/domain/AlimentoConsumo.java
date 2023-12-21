package br.edu.infnet.appdieta.model.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Alimento alimento;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Refeicao> refeicoes;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Receita> receitas = new ArrayList<>();

    @Override
    public String toString() {
        return String.format("AlimentoConsumo{id=%d, alimento=%s, quantidade=%.2f, unidade='%s'}",
                id, alimento, quantidade, unidade);
    }
}
