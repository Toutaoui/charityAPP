package org.example.charityapp.repositories;

import org.example.charityapp.entities.SuiviDonateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SuiviDonateurRepository extends JpaRepository<SuiviDonateur, Long> {
    List<SuiviDonateur> findByCampagneId(Long campagneId);
}
