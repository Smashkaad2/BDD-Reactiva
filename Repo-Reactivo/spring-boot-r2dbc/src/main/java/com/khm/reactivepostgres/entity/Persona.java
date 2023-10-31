package com.khm.reactivepostgres.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Builder
@Data
@Table("persona")
public class Persona {
    @Id
    private Long id;
    private String nombre;
    private String apellido;
    private String correo;
    private Character rol;
}

// >Intentos y documentación
// Relaciones de entidades en JDBC
     // @OneToMany(fetch = FetchType.LAZY, mappedBy = "persona", cascade = CascadeType.ALL)
    // private List<Curso> cursos;