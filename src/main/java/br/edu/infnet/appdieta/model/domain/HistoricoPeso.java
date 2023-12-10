package br.edu.infnet.appdieta.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class HistoricoPeso {
    @Id
    @GeneratedValue
    private Integer id;

    private LocalDateTime data;
    private double valor;

    @ManyToOne(cascade = CascadeType.ALL)
    private Usuario usuario;

    @Override
    public String toString() {
        return String.format("HistoricoPeso{data=%s, valor=%.2f}", data, valor);
    }
}
