package com.salaohair.api.models;

import com.salaohair.api.enums.TipoUsuario;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private String email;

    private String senha;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

}



