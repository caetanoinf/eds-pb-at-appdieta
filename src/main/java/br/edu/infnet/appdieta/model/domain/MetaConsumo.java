package br.edu.infnet.appdieta.model.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MetaConsumo {
    private String tipo;
    private double valor;

    @Override
    public String toString() {
        return String.format("MetaConsumo{tipo='%s', valor=%.2f}", tipo, valor);
    }
}
