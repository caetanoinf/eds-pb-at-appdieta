package br.edu.infnet.appdieta.model.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class TabelaNutricional {
    @Id
    @Column(name = "alimento_id")
    private Integer id;

    private double calorias;
    private double proteinas;
    private String unidade;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "alimento_id")
    @JsonBackReference
    private Alimento alimento;

    @Override
    public String toString() {
        return String.format("TabelaNutricional{calorias=%.2f, proteinas=%.2f, unidade='%s'}",
                calorias, proteinas, unidade);
    }
}
