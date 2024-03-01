package rinha.rinha.dto;

import rinha.rinha.model.Cliente;

import java.sql.Timestamp;

public record ClienteExtratoDTO(Integer total, Timestamp data_extrato, Integer limite) {
    public ClienteExtratoDTO(Cliente c) {
        this(c.Saldo, new Timestamp(System.currentTimeMillis()), c.Limite);
    }
}
