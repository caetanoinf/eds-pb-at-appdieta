package br.edu.infnet.appdieta.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "alimento")
    @PrimaryKeyJoinColumn
    @JsonManagedReference
    private TabelaNutricional tabelaNutricional;

    @OneToMany(mappedBy = "alimento", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<AlimentoConsumo> consumos;

    @Override
    public String toString() {
        return String.format("Alimento{id=%d, nome='%s', categoria='%s', %s}",
                id, nome, categoria, tabelaNutricional.toString());
    }
}
