package com.khm.reactivepostgres.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.khm.reactivepostgres.entity.Materia;
import com.khm.reactivepostgres.repository.RepositorioMateria;


import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@RequiredArgsConstructor
@Transactional 
public class MateriaServicio implements IMateriaServicio{
    private final RepositorioMateria repositorioMateria;

    @Override
    public Mono<Materia> crearMateriaNueva(Materia materia) {
        return repositorioMateria.save(materia);
    }

    @Override
    public Flux<Materia> obtenerTodasLasMaterias() {
        return repositorioMateria.findAll();
    }

    @Override
    public Mono<Materia> obtenerMateriaId(Long id) {
        return repositorioMateria.findById(id);
    }

    @Override
    public Mono<Void> borrarMateriaSer(Materia materiaBorrada) {
        return repositorioMateria.delete(materiaBorrada);
    }

    @Override
    public Mono<Materia> actualizarMateriaSer(Materia materiaUpdated) {
        return repositorioMateria.findById(materiaUpdated.getId()).flatMap(materiaResult -> repositorioMateria.save(materiaUpdated));
    }
    
}
