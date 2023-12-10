package br.edu.infnet.appdieta.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;

    @OneToOne
    private PlanoAlimentar planoAlimentar;

    @OneToOne(cascade = CascadeType.ALL)
    private MetaConsumo metaConsumo;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<HistoricoPeso> historicoPeso;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Refeicao> refeicoes;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Receita> receitas;

    @Override
    public String toString() {
        return String.format("Usuario{id=%d, nome='%s', email='%s', planoAlimentar=%s, metaConsumo=%s, historicoPeso=%s, refeicoes=%s, receitas=%s}",
                id, nome, email, planoAlimentar, metaConsumo, historicoPeso, refeicoes, receitas);
    }
}
