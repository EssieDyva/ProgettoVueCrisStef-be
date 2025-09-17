package com.criste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.criste.models.Fermata;

@Repository
public interface FermataRepository extends JpaRepository<Fermata, Long> {
    
}
