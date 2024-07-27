package com.salaohair.api.dto.request;

import com.salaohair.api.enums.AgendamentoStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class AgendamentoRequest{
        private  Long clientId;
        private Long profissionalId;
        private Long servicosId;
        private LocalDateTime dataHora;
        private BigDecimal valorTotal;
        private AgendamentoStatus statusStr;
        private String observacoes;
}
