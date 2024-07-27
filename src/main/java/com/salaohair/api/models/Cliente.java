package com.salaohair.api.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String celular;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;


}
