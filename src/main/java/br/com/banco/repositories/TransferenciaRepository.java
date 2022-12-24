package br.com.banco.repositories;

import br.com.banco.entities.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

    @Query(value = "SELECT * FROM transferencia t " +
            "WHERE ((NVL(?1,0) = 0 ) OR (t.conta_id = ?1)) " +
            "AND ((NVL(?2,'S') = 'S' ) OR (t.nome_Operador_Transacao = ?2)) " +
            "AND t.data_Transferencia BETWEEN ?3 AND ?4",
            nativeQuery = true)
    List<Transferencia> findByContaAndOperadorAndData(Long contaId, String nomeOperadorTransacao, LocalDate dataInicio, LocalDate dataFim);
}
