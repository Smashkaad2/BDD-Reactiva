package com.khm.reactivepostgres.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.khm.reactivepostgres.entity.Nota;
import com.khm.reactivepostgres.repository.RepositorioNota;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Transactional
public class NotaServicio implements INotaServicio {
    private final RepositorioNota repositorioNota;

    @Override
    public Mono<Nota> crearNotaNueva(Nota notaNueva) {
        return repositorioNota.save(notaNueva);
    }

}
