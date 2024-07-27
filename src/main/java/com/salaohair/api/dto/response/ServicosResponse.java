package com.salaohair.api.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServicosResponse {
        private Long id;
        private String nome;
        private String descricao;
        private Integer duracaoMinutos;
        private Double valor;
}
