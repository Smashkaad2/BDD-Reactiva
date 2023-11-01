package com.khm.reactivepostgres.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Builder
@Data
@Table("curso")
public class Curso {
    @Id
    private Long id;
    private String numero;
    private String fecha_inicio;
    private String fecha_fin;

    @Column("materia_id")
    private Long materiaId;

    @Column("profesor_id")
    private Long profesorId;

    @Column("estudiante_id")
    private Long estudianteId;

}
