package com.salaohair.api.dto;

import com.salaohair.api.enums.AgendamentoStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public record AgendamentoDTO(
        Long id,
        Long clientId,
        Long profissionalId,
        Long servicosId,
        LocalDateTime dataHora,
        BigDecimal valorTotal,
        AgendamentoStatus statusStr,
        String observacoes
) {
}
