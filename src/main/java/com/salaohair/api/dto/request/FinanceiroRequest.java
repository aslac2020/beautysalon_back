package com.salaohair.api.dto.request;

import com.salaohair.api.enums.TipoTransacao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FinanceiroRequest{
        private Long profissionalId;
        private TipoTransacao tipoTransacao;
        private Date dataTransacao;
        private Double valor;
        private String descricao;

}
