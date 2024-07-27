package com.salaohair.api.dto.response;

import com.salaohair.api.enums.TipoUsuario;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UsuarioResponse{
        private Long id;
        private String nome;
        private String email;
        private String senha;
        private TipoUsuario tipoUsuario;
        private Date dataCriacao;


}
