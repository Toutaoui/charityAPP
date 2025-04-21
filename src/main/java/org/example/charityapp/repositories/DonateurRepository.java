package org.example.charityapp.repositories;

import org.example.charityapp.Projection.DonateurProjection;
import org.example.charityapp.entities.Donateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface DonateurRepository extends JpaRepository<Donateur, Long> {
    List<DonateurProjection> findByDateFinAfter(LocalDate date); // actifs
    Optional<Donateur> findByEmail(String email);

    @Query("SELECT d FROM Donateur d ORDER BY (SELECT SUM(s.montant) FROM SuiviDonateur s WHERE s.campagne = d) DESC")
    List<Donateur> findMostContributed();
}