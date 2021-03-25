package br.com.julgamento.repository;

import br.com.julgamento.domain.SessaoJulgamento;
import br.com.julgamento.domain.Usuario;
import br.com.julgamento.domain.VotoParticipacao;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface VotoParticipacaoRepository extends MongoRepository<VotoParticipacao, String> {
    Optional<VotoParticipacao> findByAssociadoAndSessaoJulgamento(Usuario associado, SessaoJulgamento sessaoJulgamento);

    List<VotoParticipacao> findBySessaoJulgamento(SessaoJulgamento sessaoJulgamento);
}
