package rinha.rinha.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rinha.rinha.dto.Transacao;


@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
