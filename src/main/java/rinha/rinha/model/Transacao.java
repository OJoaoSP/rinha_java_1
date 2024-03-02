package rinha.rinha.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import rinha.rinha.dto.TransacaoDTO;
import java.sql.Timestamp;

@Entity(name = "transacoes")
@Table(name = "transacoes")
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Column(name= "cliente_id")
    public Integer clienteId;
    public Integer Valor;
    public String Tipo;
    public String Descricao;
    public Timestamp RealizadaEm;

    public Transacao(TransacaoDTO dado, Integer id) {

        clienteId = id;
        Valor = dado.valor();
        Tipo = dado.tipo();
        Descricao = dado.descricao();
        RealizadaEm = new Timestamp(System.currentTimeMillis());

    }
}
