package br.edu.infnet.appdieta.model.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Receita {
    private Integer id;
    private String nome;
    private List<AlimentoConsumo> alimentos;
    private Boolean ehPublica;

    public Receita() {
        alimentos = new ArrayList<AlimentoConsumo>();
    }

    public void adicionarAlimento(AlimentoConsumo alimentoConsumo) {
        alimentos.add(alimentoConsumo);
    }

    @Override
    public String toString() {
        return String.format("Receita{id='%d', nome='%s', alimentos=%s, ehPublica=%s}", id, nome, alimentos, ehPublica);
    }
}
