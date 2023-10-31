package com.khm.reactivepostgres.service;

import com.khm.reactivepostgres.entity.Materia;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IMateriaServicio {
    Mono<Materia> crearMateriaNueva(Materia materia);
    Flux<Materia> obtenerTodasLasMaterias();
    Mono<Materia> obtenerMateriaId(Long id);
    Mono<Void> borrarMateriaSer(Materia materiaBorrada);
    Mono<Materia> actualizarMateriaSer(Materia materiaUpdated);

    
}
