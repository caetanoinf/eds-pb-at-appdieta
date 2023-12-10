package br.edu.infnet.appdieta.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Receita {
    @Id
    @GeneratedValue
    private Integer id;
    private String nome;
    private Boolean ehPublica;

    @ManyToMany(mappedBy = "receitas", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<AlimentoConsumo> alimentos;

    @ManyToOne(optional = true)
    private Usuario usuario;

    public Receita() {
        alimentos = new ArrayList<AlimentoConsumo>();
    }

    public void adicionarAlimento(AlimentoConsumo alimentoConsumo) {
        alimentos.add(alimentoConsumo);
    }

    @Override
    public String toString() {
        return String.format("Receita{id='%d', nome='%s', alimentos=%s, ehPublica=%s}", id, nome, alimentos, ehPublica);
    }
}
