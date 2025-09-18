package com.criste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.criste.models.NumeriLinea;

@Repository
public interface NumeriLineaRepository extends JpaRepository<NumeriLinea, Integer> {
}