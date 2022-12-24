package br.com.banco.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "TRANSFERENCIA")
public class Transferencia implements Serializable {

    private static final long serialVersionUID = -408814031129039108L;

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "DATA_TRANSFERENCIA")
    private LocalDateTime dataTransferencia;

    @Column(name = "VALOR", precision = 20, scale = 2)
    private BigDecimal valor;

    @Column(name = "TIPO", length = 15)
    private String tipo;

    @Column(name = "NOME_OPERADOR_TRANSACAO", length = 50)
    private String nomeOperadorTransacao;

    @Column(name = "CONTA_ID")
    private Long contaId;

}
