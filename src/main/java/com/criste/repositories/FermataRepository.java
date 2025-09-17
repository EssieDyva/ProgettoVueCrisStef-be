package com.criste.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.criste.models.Fermata;

@Repository
public interface FermataRepository extends CrudRepository<Fermata, Long> {
    
}
