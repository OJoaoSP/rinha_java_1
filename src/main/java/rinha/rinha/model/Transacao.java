package rinha.rinha.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import rinha.rinha.dto.TransacaoDTO;
import java.sql.Timestamp;

@Entity(name = "transacoes")
@Table(name = "transacoes")
@EqualsAndHashCode(of = "id")
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    public Integer ClienteId;
    public Integer Valor;
    public String Tipo;
    public String Descricao;
    public Timestamp RealizadaEm;

    public Transacao(TransacaoDTO dado, Integer id) {

        ClienteId = id;
        Valor = dado.valor();
        Tipo = dado.tipo();
        Descricao = dado.descricao();
        RealizadaEm = new Timestamp(System.currentTimeMillis());

    }
}
