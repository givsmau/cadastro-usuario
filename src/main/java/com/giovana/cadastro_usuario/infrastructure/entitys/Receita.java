package com.giovana.cadastro_usuario.infrastructure.entitys;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "receita")
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "ingredientes", columnDefinition = "TEXT")
    private String ingredientes;

    @Column(name = "modo_preparo", columnDefinition = "TEXT")
    private String modoPreparo;
}
