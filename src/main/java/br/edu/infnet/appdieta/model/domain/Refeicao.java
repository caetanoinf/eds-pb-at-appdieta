package br.edu.infnet.appdieta.model.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Refeicao {
    @Id
    @GeneratedValue
    private Integer id;
    private String sessao;
    private LocalDateTime dataConsumo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    @JsonBackReference
    private Usuario usuario;

    @ManyToMany(mappedBy = "refeicoes", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<AlimentoConsumo> alimentos;

    public Refeicao() {}

    @Override
    public String toString() {
        return String.format("Refeicao{id=%d, dataConsumo=%s, alimentos=%s, sessao='%s'}",
                id, dataConsumo, alimentos, sessao);
    }
}
