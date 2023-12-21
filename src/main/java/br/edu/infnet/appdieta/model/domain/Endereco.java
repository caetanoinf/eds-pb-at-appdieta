package br.edu.infnet.appdieta.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;

    public Endereco(String cep) {
        this();
        this.cep = cep;
    }

    @Override
    public String toString() {
        return String.format("Endereco{id=%d, cep='%s', logradouro='%s', bairro='%s', localidade='%s', uf='%s'}",
                id, cep, logradouro, bairro, localidade, uf);
    }
}
