package org.example.charityapp.controllers;

import org.example.charityapp.Projection.DonateurProjection;
import org.example.charityapp.entities.Donateur;
import org.example.charityapp.services.DonateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/donateurs")
@Validated

public class DonateurController {

    @Autowired
    private DonateurService service;

    @GetMapping("/actifs")
    public List<DonateurProjection> getActiveDonateurs() {
        return service.getActiveDonateurs();
    }

    @PostMapping
    public ResponseEntity<Donateur> create(@RequestBody @Valid Donateur donateur) {
        return ResponseEntity.ok(service.save(donateur));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Donateur> getById(@PathVariable Long id) {
        return service.getById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Donateur> update(@PathVariable Long id, @RequestBody @Valid Donateur donateur) {
        return service.getById(id)
                .map(existing -> {
                    donateur.setId(id);
                    return ResponseEntity.ok(service.save(donateur));
                })
                .orElse(ResponseEntity.notFound().build());
    }

}

