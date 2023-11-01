package com.khm.reactivepostgres.controller;

import com.khm.reactivepostgres.entity.Materia;
import com.khm.reactivepostgres.service.IMateriaServicio;
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
@RequestMapping("/Materia")
@RequiredArgsConstructor
public class ControladorMateria {

    private final IMateriaServicio materiaServicio;

  
    @PostMapping
    public ResponseEntity<Mono<Materia>> crearMateria(@RequestBody Materia materiaNueva) {
        return ResponseEntity.ok(materiaServicio.crearMateriaNueva(materiaNueva));
    }

    @GetMapping
    public ResponseEntity<Flux<Materia>> getAllMaterias() {
        return ResponseEntity.ok(materiaServicio.obtenerTodasLasMaterias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<Materia>> getMateria(@PathVariable Long id) {
        return ResponseEntity.ok(materiaServicio.obtenerMateriaId(id));
    }

   
    @DeleteMapping
    public ResponseEntity<Mono<Void>> borrarPersona(@RequestBody Materia materiaBorrar) {
        return ResponseEntity.ok(materiaServicio.borrarMateriaSer(materiaBorrar));
    }

  
    @PutMapping
    public ResponseEntity<Mono<Materia>> updateMember(@RequestBody Materia materia) {
        return ResponseEntity.ok(materiaServicio.actualizarMateriaSer(materia));
    }

}

// >Intentos y documentación
// RepositorioMateria repoMaterias;

// //Mostrar todas las materias en el repo
// @GetMapping
// public Flux<Materia> getMaterias(){
// return repoMaterias.findAll();
// }

// //Encontrar una materia por medio de su Id en el repo
// @GetMapping("/{id}")
// public Mono<Materia> getMateria(@PathVariable Integer materia_id){
// return repoMaterias.findById(materia_id);
// }

// //Crear una materia en el repo
// @PostMapping
// public Mono<Materia> crearMateria(@RequestBody Materia materiaNueva){

// return repoMaterias.save(materiaNueva);
// }

// @PutMapping//actualizar Datos de materia en el repo
// public Mono<Materia> actualizarMateria(@RequestBody Materia
// materiaActualizada, @PathVariable Integer id_materia){
// return repoMaterias.findById(id_materia).map((materiaUp)->{
// materiaUp.setNombreMateria(materiaActualizada.getNombreMateria());
// materiaUp.setCreditos(materiaActualizada.getCreditos());
// materiaUp.setMateria_id(id_materia);
// return materiaUp;
// }).flatMap(materiaUp -> repoMaterias.save(materiaUp));
// }

// @DeleteMapping("/{id}")// Borrar materia del repositorio por medio de su Id
// public Mono<Void> borrarMateria(@PathVariable Integer id_materia){
// return repoMaterias.deleteById(id_materia);
// }