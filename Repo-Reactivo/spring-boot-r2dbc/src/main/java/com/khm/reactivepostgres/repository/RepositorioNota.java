package com.khm.reactivepostgres.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.khm.reactivepostgres.entity.Nota;

@Repository
public interface RepositorioNota extends R2dbcRepository<Nota, Long>{
    
}
