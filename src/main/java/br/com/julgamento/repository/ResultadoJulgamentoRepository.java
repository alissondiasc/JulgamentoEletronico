package br.com.julgamento.repository;

import br.com.julgamento.domain.ResultadoJulgamento;
import br.com.julgamento.domain.SessaoJulgamento;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResultadoJulgamentoRepository extends MongoRepository<ResultadoJulgamento, String> {

    ResultadoJulgamento findBySessaoJulgamento(SessaoJulgamento sessaoJulgamento);
}
