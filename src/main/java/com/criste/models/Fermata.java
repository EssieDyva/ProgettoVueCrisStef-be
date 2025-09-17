package com.criste.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fermata {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idFermata;

    private Number numeroLinea;
    private String nomeFermata;
}
