package com.criste.controllers;

import com.criste.models.Fermate;
import com.criste.repositories.FermateRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/fermate")
public class FermateController {

    private final FermateRepository fermataRepository;

    public FermateController(FermateRepository fermataRepository) {
        this.fermataRepository = fermataRepository;
    }

    @GetMapping("/listaFermate")
    public ResponseEntity<List<Fermate>> getAllFermate() {
        List<Fermate> fermate = fermataRepository.findAll();
        return ResponseEntity.ok(fermate);
    }

    @PostMapping("/aggiungiFermata")
    public ResponseEntity<Fermate> postFermata(@Validated @RequestBody Fermate fermate) {
        Fermate nuovaFermata = fermataRepository.save(fermate);
        return ResponseEntity.ok(nuovaFermata);
    }

    @DeleteMapping("/rimuoviFermata/{idFermata}")
    public ResponseEntity<Void> deleteFermata(@PathVariable Integer idFermata) {
        if (!fermataRepository.existsById(idFermata)) {
            return ResponseEntity.notFound().build();
        }
        try {
            fermataRepository.deleteById(idFermata);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}