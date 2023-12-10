package br.edu.infnet.appdieta.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class MetaConsumo {
    @Id
    @GeneratedValue
    private Integer id;

    private String tipo;
    private double valor;

    @Override
    public String toString() {
        return String.format("MetaConsumo{tipo='%s', valor=%.2f}", tipo, valor);
    }
}
