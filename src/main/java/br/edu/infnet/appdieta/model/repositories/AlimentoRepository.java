package br.edu.infnet.appdieta.model.repositories;
import br.edu.infnet.appdieta.model.domain.Alimento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlimentoRepository extends CrudRepository<Alimento, Integer> {
}
