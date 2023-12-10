package br.edu.infnet.appdieta.model.repositories;

import br.edu.infnet.appdieta.model.domain.Receita;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceitaRepository extends CrudRepository<Receita, Integer> {
}
