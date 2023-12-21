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
public class Receita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Boolean ehPublica;

    @ManyToMany(mappedBy = "receitas", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<AlimentoConsumo> alimentos;

    @ManyToOne(optional = true)
    @JsonBackReference
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
