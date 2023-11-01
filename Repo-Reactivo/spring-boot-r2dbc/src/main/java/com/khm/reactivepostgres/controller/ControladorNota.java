package com.khm.reactivepostgres.controller;

import com.khm.reactivepostgres.entity.Nota;
import com.khm.reactivepostgres.service.INotaServicio;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/Nota")
@RequiredArgsConstructor

public class ControladorNota {
    private final INotaServicio notaServicio;

    // Crear un curso nuevo en el repo
    @PostMapping
    public ResponseEntity<Mono<Nota>> crearNota(@RequestBody Nota notaNueva) {
        return ResponseEntity.ok(notaServicio.crearNotaNueva(notaNueva));
    }

}
