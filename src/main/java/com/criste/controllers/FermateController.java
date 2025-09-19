package com.criste.controllers;

import com.criste.models.Fermate;
import com.criste.models.NumeriLinea;
import com.criste.repositories.FermateRepository;
import com.criste.repositories.NumeriLineaRepository;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
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
    private final NumeriLineaRepository numeriLineaRepository;

    public FermateController(FermateRepository fermataRepository, NumeriLineaRepository numeriLineaRepository) {
        this.fermataRepository = fermataRepository;
        this.numeriLineaRepository = numeriLineaRepository;
    }

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

    @PostMapping("/aggiungiFermata")
    public ResponseEntity<Fermate> postFermata(@Validated @RequestBody Fermate fermate) {
        Fermate nuovaFermata = fermataRepository.save(fermate);
        if (nuovaFermata == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(nuovaFermata);
    }
}