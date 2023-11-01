package com.khm.reactivepostgres.controller;

import com.khm.reactivepostgres.entity.Nota;
import com.khm.reactivepostgres.service.INotaServicio;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/Nota")
@RequiredArgsConstructor

public class ControladorNota {
    private final INotaServicio notaServicio;

    @PostMapping
    public ResponseEntity<Mono<Nota>> crearNota(@RequestBody Nota notaNueva) {
        return ResponseEntity.ok(notaServicio.crearNotaNueva(notaNueva));
    }

    @GetMapping
    public ResponseEntity<Flux<Nota>> getAllCursos() {
        return ResponseEntity.ok(notaServicio.obtenerTodasLasNotas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<Nota>> getCurso(@PathVariable Long id) {
        return ResponseEntity.ok(notaServicio.obtenerNotaId(id));
    }

    @DeleteMapping
    public ResponseEntity<Mono<Void>> borrarPersona(@RequestBody Nota notaBorrar) {
        return ResponseEntity.ok(notaServicio.borrarNotaSer(notaBorrar));
    }

 
    @PutMapping
    public ResponseEntity<Mono<Nota>> updateCurso(@RequestBody Nota notaAc) {
        return ResponseEntity.ok(notaServicio.actualizarNotaSer(notaAc));
    }

}
