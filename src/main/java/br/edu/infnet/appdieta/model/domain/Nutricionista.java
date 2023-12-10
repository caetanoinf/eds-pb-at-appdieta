package br.edu.infnet.appdieta.model.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Nutricionista {
    @Id
    private String registro;

    private String qualificacao;
    private String contato;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PlanoAlimentar> planosAlimentares;

    @Override
    public String toString() {
        return String.format("Nutricionista{%s, registro='%s', qualificacao='%s', contato='%s', %s}",
                super.toString(), registro, qualificacao, contato, planosAlimentares.toString());
    }
}
