package br.com.banco.controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class TransferenciaController {

    @GetMapping(value = "/transferencia")
    public String transf(){
        return "TRANSFERENCIA";
    }
}
