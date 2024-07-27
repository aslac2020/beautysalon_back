package com.salaohair.api.dto.response;

import com.salaohair.api.enums.TipoTransacao;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class FinanceiroResponse {
        private Long id;
        private Long profissionalId;
        private TipoTransacao tipoTransacao;
        private Date dataTransacao;
        private Double valor;
        private String descricao;

}
