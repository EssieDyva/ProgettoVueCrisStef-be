package com.criste.controllers;

import com.criste.models.Fermate;
import com.criste.repositories.FermateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fermate")
public class FermateControllers
{

    @Autowired
    private FermateRepository fermataRepository;

    @GetMapping
    public List<Fermate> getAllFermate() {
        return fermataRepository.findAll();
    }

    @GetMapping("/linea/{numeroLinea}")
    public List<Fermate> getFermateByLinea(@PathVariable int numeroLinea) {
        return fermataRepository.findByLinea_NumeroLinea(numeroLinea);
    }
}
