package org.example.charityapp.services;

import org.example.charityapp.Projection.DonateurProjection;
import org.example.charityapp.entities.Donateur;
import org.example.charityapp.repositories.DonateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DonateurService {

    @Autowired
    private DonateurRepository donateurRepository;

    public List<DonateurProjection> getActiveDonateurs() {
        return donateurRepository.findByDateFinAfter(LocalDate.now());
    }

    public Optional<Donateur> findByEmail(String email) {
        return donateurRepository.findByEmail(email);
    }

    public List<Donateur> getMostContributed() {
        return donateurRepository.findMostContributed();
    }

    public Donateur save(Donateur d) {
        return donateurRepository.save(d);
    }

    public void delete(Long id) {
        donateurRepository.deleteById(id);
    }

    public Optional<Donateur> getById(Long id) {
        return donateurRepository.findById(id);
    }
}
