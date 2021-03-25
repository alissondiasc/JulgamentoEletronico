package br.com.julgamento.repository;

import br.com.julgamento.domain.SessaoJulgamento;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SessaoJulgamentoRepository extends MongoRepository<SessaoJulgamento, String> {
}
