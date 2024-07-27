package com.salaohair.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServicosRequest{
        private String nome;
        private String descricao;
        private Integer duracaoMinutos;
        private Double valor;
}
