package br.edu.infnet.appdieta.model.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Nutricionista extends Usuario {
    private String registro;
    private String qualificacao;
    private String contato;

    private List<PlanoAlimentar> planosAlimentares;

    @Override
    public String toString() {
        return String.format("Nutricionista{%s, registro='%s', qualificacao='%s', contato='%s', %s}",
                super.toString(), registro, qualificacao, contato, planosAlimentares.toString());
    }
}
