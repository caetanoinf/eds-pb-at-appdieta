package br.edu.infnet.appdieta.model.repositories;

import br.edu.infnet.appdieta.model.domain.Refeicao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefeicaoRepository extends CrudRepository<Refeicao, Integer> {
}
