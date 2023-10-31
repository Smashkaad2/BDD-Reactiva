package com.khm.reactivepostgres.controller;

import com.khm.reactivepostgres.entity.Persona;
import com.khm.reactivepostgres.service.IPersonaServicio;
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
@RequestMapping("/Persona")
@RequiredArgsConstructor

public class ControladorPersona {

    private final IPersonaServicio personaServicio;

    // Crear una persona nueva en el repo
    @PostMapping
    public ResponseEntity<Mono<Persona>> crearPersona(@RequestBody Persona personaNueva) {
        return ResponseEntity.ok(personaServicio.crearPersonaPrueba(personaNueva));
    }

    // Mostrar todas las personas en el repo
    @GetMapping
    public ResponseEntity<Flux<Persona>> getAllPersonas() {
        return ResponseEntity.ok(personaServicio.obtenerTodasPersonas());
    }

    // Encontrar a una persona en el repo por medio de su Id
    @GetMapping("/{id}")
    public ResponseEntity<Mono<Persona>> getPersona(@PathVariable Long id) {
        return ResponseEntity.ok(personaServicio.obtenerPersonaId(id));
    }

    // Borrar persona existente del repositorio por medio de su Id
    @DeleteMapping
    public ResponseEntity<Mono<Void>> borrarPersona(@RequestBody Persona perosnaBorrar) {
        return ResponseEntity.ok(personaServicio.borrarPersonaSer(perosnaBorrar));
    }

    //Actualizar datos de persona en el repo
    @PutMapping
    public ResponseEntity<Mono<Persona>> updateMember(@RequestBody Persona persona) {
        return ResponseEntity.ok(personaServicio.actualizarPersonaSer(persona));
    }

}


// >Intentos y documentación

    // Actualizar a una persona del repositorio

    // public ControladorPersona(PersonaServicio personaServicio){
    // this.personaServicio = personaServicio;
    // }

    // Se pueden mandar datos por la url o el body, RequestBody es para mandarlo por
    // el body y pathVariable es para pasarlo por el url pero se debe declarar por
    // el mapping
    // @PutMapping("/{id}")//Actualizar a una persona del repositorio
    // public Mono<Persona> actualizarPersona(@RequestBody Persona
    // personaActualizada, @PathVariable Integer id){
    // return repoPersonas.findById(id).map((personaUp)->{
    // personaUp.setNombre(personaActualizada.getNombre());
    // personaUp.setApellido(personaActualizada.getApellido());
    // personaUp.setCorreo(personaActualizada.getCorreo());
    // personaUp.setRol(personaActualizada.getRol());
    // // personaUp.setPersona_id(id);
    // return personaUp;
    // }).flatMap(personaUp-> repoPersonas.save(personaUp));
    // }

    // @PutMapping("/id/{id}/nombre/{nombre}")//Actualizar a una persona del
    // repositorio
    // public Mono<Persona> actualizarPersona(@RequestBody Persona
    // personaActualizada, @PathVariable Integer id, @PathVariable String nombre)

    // @GetMapping
    // public ResponseEntity<Flux<Persona>> getPersona() {
    // return ResponseEntity.ok(personaServicio.obtenerPersona());
    // }

    // //Encontrar una persona por medio de su Id en el repo
    // @GetMapping("/{id}")
    // public ResponseEntity<Mono<Persona>> getPersona(@PathVariable Long id) {
    // return ResponseEntity.ok(personaServicio.obtenerPersonaId(id));
    // }

    // Crear una persona nueva en el repo
    // @PostMapping
    // public ResponseEntity<Mono<Persona>> crearPersona(@RequestBody Persona
    // personaNueva) { // Se esta devolviendo pero
    // // con el formato de
    // // ResponseEntity
    // // ResponseEntity.notFound();
    // return ResponseEntity.ok(personaServicio.crearPersonaPrueba(new
    // Persona(personaNueva.getNombre(),
    // personaNueva.getApellido(), personaNueva.getCorreo(),
    // personaNueva.getRol())));// El ok, significa para
    // darle un
    // aprovado a la creación del objeto
    // y que se va a mandar una copia al
    // cliente. Es una buena practica
    // siempre enviar codigos de
    // protocolos de comunicación
    // }// El controlador se comunica con servicios y los servicios con los
    // repositorios. uNIDIRECCIONAL UNICAMENTE

    // Borrar persona existente del repositorio por medio de su Id
    // @DeleteMapping("/{id}")
    // public Mono<Void> borrarPersona(@PathVariable Integer id_persona){
    // return repoPersonas.deleteById(id_persona);
    // }