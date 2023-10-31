package com.khm.reactivepostgres.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.khm.reactivepostgres.entity.Curso;
import com.khm.reactivepostgres.entity.Persona;
import com.khm.reactivepostgres.repository.RepositorioCurso;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Transactional // Lo maneja como una transacción Bancaria, o se transfiere todo o nada.
public class CursoServicio implements ICursoServicio {
    private final RepositorioCurso repositorioCurso;

    @Override
    public Mono<Curso> crearCursoNuevo(Curso cursoNuevo) {
        return repositorioCurso.save(cursoNuevo);
    }

}