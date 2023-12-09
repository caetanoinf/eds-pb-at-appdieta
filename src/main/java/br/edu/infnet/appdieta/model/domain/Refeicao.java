package br.edu.infnet.appdieta.model.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Refeicao {
    private Integer id;
    private String sessao;
    private List<AlimentoConsumo> alimentos;
    private LocalDateTime dataConsumo;

    public Refeicao() {
        alimentos = new ArrayList<AlimentoConsumo>();
    }

    public void adicionarAlimentoConsumo(AlimentoConsumo alimento) {
        alimentos.add(alimento);
    }

    @Override
    public String toString() {
        return String.format("Refeicao{id=%d, dataConsumo=%s, alimentos=%s, sessao='%s'}",
                id, dataConsumo, alimentos, sessao);
    }
}
