package br.edu.infnet.appdieta.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private PlanoAlimentar planoAlimentar;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private MetaConsumo metaConsumo;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Endereco endereco;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JsonManagedReference
    private List<HistoricoPeso> historicoPeso;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JsonIgnore
    private List<Refeicao> refeicoes;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JsonManagedReference
    private List<Receita> receitas;

    @Override
    public String toString() {
        return String.format("Usuario{id=%d, nome='%s', email='%s', planoAlimentar=%s, metaConsumo=%s, historicoPeso=%s, refeicoes=%s, receitas=%s}",
                id, nome, email, planoAlimentar, metaConsumo, historicoPeso, refeicoes, receitas);
    }
}
