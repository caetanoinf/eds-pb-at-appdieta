package br.edu.infnet.appdieta.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Alimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String categoria;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "alimento")
    @PrimaryKeyJoinColumn
    private TabelaNutricional tabelaNutricional;

    @OneToMany(mappedBy = "alimento")
    private List<AlimentoConsumo> consumos;

    @Override
    public String toString() {
        return String.format("Alimento{id=%d, nome='%s', categoria='%s', %s}",
                id, nome, categoria, tabelaNutricional.toString());
    }
}
