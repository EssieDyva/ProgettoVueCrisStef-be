package com.criste.repositories;

import com.criste.models.Fermate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FermateRepository extends JpaRepository<Fermate, Integer> {
    
}
