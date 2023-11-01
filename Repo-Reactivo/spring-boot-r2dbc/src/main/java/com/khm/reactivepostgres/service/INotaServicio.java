package com.khm.reactivepostgres.service;

import com.khm.reactivepostgres.entity.Nota;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface INotaServicio {
    Mono<Nota> crearNotaNueva(Nota notaNueva);
    Flux<Nota> obtenerTodasLasNotas();
    Mono<Nota> obtenerNotaId(Long id);
    Mono<Void> borrarNotaSer(Nota notaBorrada);
    Mono<Nota> actualizarNotaSer(Nota notaUpdated);

}
