package com.khm.reactivepostgres.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.khm.reactivepostgres.entity.Persona;
import com.khm.reactivepostgres.repository.RepositorioPersona;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Transactional // Lo maneja como una transacción Bancaria, o se transfiere todo o nada.
public class PersonaServicio implements IPersonaServicio {
    private final RepositorioPersona repositorioPersona;

    public Mono<Persona> crearPersonaPrueba(Persona personaNueva) {
        return repositorioPersona.save(personaNueva);
    }

    @Override
    public Flux<Persona> obtenerTodasPersonas() {
        return repositorioPersona.findAll();
    }

    @Override
    public Mono<Persona> obtenerPersonaId(Long id) {
       return repositorioPersona.findById(id);
    }

    @Override
    public Mono<Void> borrarPersonaSer(Persona personaBorrada) {
        return repositorioPersona.delete(personaBorrada);
    }

    @Override
    public Mono<Persona> actualizarPersonaSer(Persona personaUpdated) {
        return repositorioPersona.findById(personaUpdated.getId()).flatMap(personaResult -> repositorioPersona.save(personaUpdated));
    }
}


// > Intentos y documentación
// Persona persona = Persona.builder()
            
        //     .nombre(personaNueva.getNombre())
        //     .apellido(personaNueva.getApellido())
        //     .correo(personaNueva.getCorreo())
        //     .rol(personaNueva.getRol())
        //     .build();