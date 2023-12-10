package br.edu.infnet.appdieta.model.repositories;

import br.edu.infnet.appdieta.model.domain.AlimentoConsumo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlimentoConsumoRepository extends CrudRepository<AlimentoConsumo, Integer> {
}
