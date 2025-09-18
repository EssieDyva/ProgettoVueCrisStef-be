package com.criste.controllers;

import com.criste.models.Fermate;
import com.criste.models.NumeriLinea;
import com.criste.repositories.FermateRepository;
import com.criste.repositories.NumeriLineaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/fermate")
public class FermateController {

    @Autowired
    private FermateRepository fermataRepository;

    @Autowired
    private NumeriLineaRepository numeriLineaRepository;

    @GetMapping("/listaFermate")
    public ResponseEntity<List<Fermate>> getAllFermate() {
        List<Fermate> fermate = fermataRepository.findAll();
        return ResponseEntity.ok(fermate);
    }

    @GetMapping("/listaNumerilinea")
    public ResponseEntity<List<NumeriLinea>> getAllNumeriLinea() {
        List<NumeriLinea> linee = numeriLineaRepository.findAll();
        return ResponseEntity.ok(linee);
    }

    @GetMapping("/fermatePerLinea/{numeroLinea}")
    public ResponseEntity<List<Fermate>> getFermateByNumeroLinea(@PathVariable Integer numeroLinea) {
        List<Fermate> fermate = fermataRepository.findByNumeroLinea(numeroLinea);
        if (fermate.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(fermate);
    }
}