package com.khm.reactivepostgres.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Data
@Builder
@Table("materia")
public class Materia {
    @Id
    private Long id;
    private String nombre;
    private Integer creditos;

}

// >Intentos y documentación
// Relaciones de entidades en JDBC
    // @OneToMany(fetch = FetchType.LAZY, mappedBy = "materia", cascade = CascadeType.ALL)
    // private List<Curso> cursos;

