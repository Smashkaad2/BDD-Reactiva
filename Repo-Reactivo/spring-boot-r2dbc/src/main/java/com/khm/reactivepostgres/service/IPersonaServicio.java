package com.khm.reactivepostgres.service;

import com.khm.reactivepostgres.entity.Persona;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPersonaServicio {
    Mono<Persona> crearPersonaPrueba(Persona personaNueva);
    Flux<Persona> obtenerTodasPersonas();
    Mono<Persona> obtenerPersonaId(Long id);
    Mono<Void> borrarPersonaSer(Persona personaBorrada);
    Mono<Persona> actualizarPersonaSer(Persona personaUpdated);
}
