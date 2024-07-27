package com.salaohair.api.dto.request;

import com.salaohair.api.enums.TipoUsuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequest{
    private String nome;
    private String email;
    private String senha;
    private TipoUsuario tipoUsuario;
    private Date dataCriacao;
}




