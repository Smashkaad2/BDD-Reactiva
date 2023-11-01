package com.khm.reactivepostgres.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Builder
@Data
@Table("nota")
public class Nota {
    @Id
    private Long id;
    private String observacion;
    private Float valor;
    private Float porcentaje;

    @Column("materia_id")
    private Long materiaId;

    @Column("profesor_id")
    private Long profesorId;

    @Column("estudiante_id")
    private Long estudianteId;

}