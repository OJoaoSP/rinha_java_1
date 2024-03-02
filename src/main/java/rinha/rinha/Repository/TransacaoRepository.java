package rinha.rinha.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rinha.rinha.model.Transacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Integer> {
    ArrayList<Transacao> findByClienteId(Integer id);
}
