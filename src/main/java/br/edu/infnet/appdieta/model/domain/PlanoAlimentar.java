package br.edu.infnet.appdieta.model.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PlanoAlimentar {
    private String objetivo;
    private String instrucoes;
    private List<Refeicao> refeicoes;

    public String toString() {
        return String.format("PlanoAlimentar{objetivo='%s', instrucoes='%s', %s}",
                objetivo, instrucoes, refeicoes.toString());
    }
}
