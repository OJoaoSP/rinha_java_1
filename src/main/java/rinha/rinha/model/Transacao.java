package rinha.rinha.dto;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

@Entity(name = "transacoes")
@Table(name = "transacoes")
@EqualsAndHashCode(of = "id")
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private Integer ClienteId;
    private Integer Valor;
    private String Tipo;
    private String Descricao;
    private Timestamp RealizadaEm;

    public Transacao(TransacaoDTO dado, Integer id) {
        ClienteId = id;
        Valor = dado.valor();
        Tipo = dado.tipo();
        Descricao = dado.descricao();
        RealizadaEm = new Timestamp(System.currentTimeMillis());

    }
}
