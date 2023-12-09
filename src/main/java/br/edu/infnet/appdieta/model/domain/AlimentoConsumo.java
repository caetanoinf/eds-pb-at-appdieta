package br.edu.infnet.appdieta.model.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlimentoConsumo {
    private Integer id;
    private Alimento alimento;
    private double quantidade;
    private String unidade;

    @Override
    public String toString() {
        return String.format("AlimentoConsumo{id=%d, alimento=%s, quantidade=%.2f, unidade='%s'}",
                id, alimento, quantidade, unidade);
    }
}
