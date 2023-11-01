package com.khm.reactivepostgres.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.khm.reactivepostgres.entity.Nota;
import com.khm.reactivepostgres.repository.RepositorioNota;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
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

    @Override
    public Flux<Nota> obtenerTodasLasNotas() {
        return repositorioNota.findAll();
    }

    @Override
    public Mono<Nota> obtenerNotaId(Long id) {
        return repositorioNota.findById(id);
    }

    @Override
    public Mono<Void> borrarNotaSer(Nota notaBorrada) {
        return repositorioNota.delete(notaBorrada);
    }

    @Override
    public Mono<Nota> actualizarNotaSer(Nota notaUpdated) {
        return repositorioNota.findById(notaUpdated.getId()).flatMap(notaResult -> repositorioNota.save(notaUpdated));
    }

    

}
