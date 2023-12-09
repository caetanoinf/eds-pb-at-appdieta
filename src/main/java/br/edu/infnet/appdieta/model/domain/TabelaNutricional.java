package br.edu.infnet.appdieta.model.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TabelaNutricional {
    private double calorias;
    private double proteinas;
    private String unidade;

    @Override
    public String toString() {
        return String.format("TabelaNutricional{calorias=%.2f, proteinas=%.2f, unidade='%s'}",
                calorias, proteinas, unidade);
    }
}
