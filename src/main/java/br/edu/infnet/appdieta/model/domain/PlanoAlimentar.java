package br.edu.infnet.appdieta.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class PlanoAlimentar {
    @Id
    @GeneratedValue
    private Integer id;

    private String objetivo;
    private String instrucoes;

    @OneToMany
    private List<Refeicao> refeicoes;

    @ManyToOne
    private Nutricionista nutricionistas;

    public String toString() {
        return String.format("PlanoAlimentar{objetivo='%s', instrucoes='%s', %s}",
                objetivo, instrucoes, refeicoes.toString());
    }
}
