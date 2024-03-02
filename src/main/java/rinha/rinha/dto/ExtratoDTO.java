package rinha.rinha.dto;

import java.util.List;

public record ExtratoDTO(ClienteExtratoDTO saldo, List<TransacaoDTO> ultimas_transacoes) {
}
