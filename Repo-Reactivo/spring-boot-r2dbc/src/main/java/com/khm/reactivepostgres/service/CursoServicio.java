package com.khm.reactivepostgres.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.khm.reactivepostgres.entity.Curso;
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
        
        // Mono<Boolean> valorcito = Mono.just(true);
        // if(repositorioPersona.existsById(cursoNuevo.getMateriaId()) == valorcito){
        //     Curso cursoSinMateriaValida = Curso.builder()
            
        //     .numero("1")
        //     .fecha_inicio("1")
        //     .fecha_fin("1")
        //     .materiaId(cursoNuevo.getMateriaId()-cursoNuevo.getMateriaId())
        //     .profesorId(cursoNuevo.getProfesorId())
        //     .estudianteId(cursoNuevo.getEstudianteId())
        //     .build();
        //     return repositorioCurso.save(cursoSinMateriaValida);
        // }
        return repositorioCurso.save(cursoNuevo);
    }

    @Override
    public Flux<Curso> obtenerTodoslosCursos() {
        return repositorioCurso.findAll();
    }

    @Override
    public Mono<Curso> obtenerCursoId(Long id) {
       return repositorioCurso.findById(id);
    }

    @Override
    public Mono<Void> borrarCursoSer(Curso cursoBorrada) {
        return repositorioCurso.delete(cursoBorrada);
    }

    @Override
    public Mono<Curso> actualizarCursoSer(Curso cursoUpdated) {
        return repositorioCurso.findById(cursoUpdated.getId()).flatMap(cursoResult -> repositorioCurso.save(cursoUpdated));
    }

    

}