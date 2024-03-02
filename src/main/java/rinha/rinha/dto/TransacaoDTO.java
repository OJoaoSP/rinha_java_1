package rinha.rinha.dto;

import rinha.rinha.model.Transacao;

import java.sql.Timestamp;

public record TransacaoDTO(Integer valor, String tipo, String descricao, Timestamp realizado_em) {
    public TransacaoDTO(Transacao t) {
        this(t.Valor, t.Tipo, t.Descricao, t.RealizadaEm);
    }
}
