package br.com.julgamento.repository;

import br.com.julgamento.domain.Pauta;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PautaRepository extends MongoRepository<Pauta, String> {
}
