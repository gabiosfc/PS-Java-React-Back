package br.com.banco.controller;

import br.com.banco.entities.Transferencia;
import br.com.banco.repositories.TransferenciaRepository;
import br.com.banco.services.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class TransferenciaController {

    @Autowired
    TransferenciaRepository repository;

    @Autowired
    TransferenciaService service;


    @GetMapping(value = "/findAll")
    public ResponseEntity<List<Transferencia>> findAll() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/findTransferenciaByFilters")
    public ResponseEntity<List<Transferencia>> findTransferenciaByDate(@RequestParam(required = false, name = "contaId") Long contaId,
                                                                       @RequestParam(required = false, name = "nomeOperador") String nomeOperadorTransacao,
                                                                       @RequestParam(required = false, name = "dataInicio", defaultValue = "0001-01-01") String dataInicio,
                                                                       @RequestParam(required = false, name = "dataFim", defaultValue = "2999-01-01") String dataFim) {

        List<Transferencia> response = service.transacaoFindByContaAndData(contaId, nomeOperadorTransacao, LocalDate.parse(dataInicio), LocalDate.parse(dataFim));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
