package com.khm.reactivepostgres.service;

import com.khm.reactivepostgres.entity.Curso;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICursoServicio {
    Mono<Curso> crearCursoNuevo(Curso cursoNuevo);
    Flux<Curso> obtenerTodoslosCursos();
    Mono<Curso> obtenerCursoId(Long id);
    Mono<Void> borrarCursoSer(Curso cursoBorrada);
    Mono<Curso> actualizarCursoSer(Curso cursoUpdated);
}