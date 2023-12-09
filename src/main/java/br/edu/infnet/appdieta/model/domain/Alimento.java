package br.edu.infnet.appdieta.model.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Alimento {
    private Integer id;
    private String nome;
    private String categoria;
    private TabelaNutricional tabelaNutricional;

    @Override
    public String toString() {
        return String.format("Alimento{id=%d, nome='%s', categoria='%s', %s}",
                id, nome, categoria, tabelaNutricional.toString());
    }
}
