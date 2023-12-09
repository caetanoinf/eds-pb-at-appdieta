package br.edu.infnet.appdieta.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class Peso {
    private LocalDateTime data;
    private double valor;

    @Override
    public String toString() {
        return String.format("Peso{data=%s, valor=%.2f}", data, valor);
    }
}
