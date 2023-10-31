package com.khm.reactivepostgres.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.khm.reactivepostgres.entity.Persona;

@Repository
public interface RepositorioPersona extends R2dbcRepository<Persona, Long>{
    
}
