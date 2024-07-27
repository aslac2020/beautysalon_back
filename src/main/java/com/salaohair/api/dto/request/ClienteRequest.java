package com.salaohair.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequest{
    private String nome;
    private String email;
    private String telefone;
    private String celular;
    private Long usuarioId;
}
