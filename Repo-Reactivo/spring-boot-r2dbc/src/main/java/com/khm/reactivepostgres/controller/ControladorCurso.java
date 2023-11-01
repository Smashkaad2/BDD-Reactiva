package com.khm.reactivepostgres.controller;

import com.khm.reactivepostgres.entity.Curso;
import com.khm.reactivepostgres.service.ICursoServicio;
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
@RequestMapping("/Curso")
@RequiredArgsConstructor

public class ControladorCurso {

    private final ICursoServicio cursoServicio;


    @PostMapping
    public ResponseEntity<Mono<Curso>> crearCurso(@RequestBody Curso cursoNuevo) {
        return ResponseEntity.ok(cursoServicio.crearCursoNuevo(cursoNuevo));
    }

    @GetMapping
    public ResponseEntity<Flux<Curso>> getAllCursos() {
        return ResponseEntity.ok(cursoServicio.obtenerTodoslosCursos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<Curso>> getCurso(@PathVariable Long id) {
        return ResponseEntity.ok(cursoServicio.obtenerCursoId(id));
    }


    @DeleteMapping
    public ResponseEntity<Mono<Void>> borrarPersona(@RequestBody Curso cursoBorrar) {
        return ResponseEntity.ok(cursoServicio.borrarCursoSer(cursoBorrar));
    }

    @PutMapping
    public ResponseEntity<Mono<Curso>> updateCurso(@RequestBody Curso cursoAc) {
        return ResponseEntity.ok(cursoServicio.actualizarCursoSer(cursoAc));
    }

}
