package br.com.banco.services;

import br.com.banco.entities.Transferencia;
import br.com.banco.exceptions.TransferenciaNotFoundException;
import br.com.banco.repositories.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransferenciaService {
    @Autowired
    TransferenciaRepository repository;

    public List<Transferencia> transacaoFindByContaAndData(Long contaId, String nomeOperadorTransacao, LocalDate dataInicio, LocalDate dataFim) {
        List<Transferencia> listaTransferencia = repository.findByContaAndOperadorAndData(contaId, nomeOperadorTransacao, dataInicio, dataFim);
        if (listaTransferencia == null || listaTransferencia.isEmpty()) {
            throw new TransferenciaNotFoundException("Não foram encontradas transações para os valores informados.");
        }
        return listaTransferencia;
    }
}
