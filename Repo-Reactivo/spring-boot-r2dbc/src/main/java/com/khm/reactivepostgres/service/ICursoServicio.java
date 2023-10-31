package com.khm.reactivepostgres.service;

import com.khm.reactivepostgres.entity.Curso;
import com.khm.reactivepostgres.entity.Persona;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICursoServicio {
    Mono<Curso> crearCursoNuevo(Curso cursoNuevo);
}