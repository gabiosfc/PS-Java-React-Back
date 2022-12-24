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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "CONTA")
public class Conta implements Serializable {

    private static final long serialVersionUID = -408814031129039108L;

    @Id
    @Column(name = "ID_CONTA")
    private Long id;

    @Column(name = "NOME_RESPONSAVEL", length = 50)
    private String nomeResponsavel;

}
