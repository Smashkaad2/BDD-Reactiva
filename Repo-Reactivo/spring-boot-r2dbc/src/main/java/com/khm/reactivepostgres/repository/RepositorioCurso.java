package com.khm.reactivepostgres.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.khm.reactivepostgres.entity.Curso;

@Repository
public interface RepositorioCurso extends R2dbcRepository<Curso, Long>{
    
}
