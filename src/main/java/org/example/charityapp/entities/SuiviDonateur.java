package org.example.charityapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SuiviDonateur {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "donateur_id")
    private Donateur campagne;


    private String nomDonateur;

    @NotNull
    private Double montant;

    @NotNull
    private LocalDate date;

  // --- Getters ---
  public Long getId() { return id; }
  public Donateur getCampagne() { return campagne; }
  public String getNomDonateur() { return nomDonateur; }
  public Double getMontant() { return montant; }
  public LocalDate getDate() { return date; }

  // --- Setters ---
  public void setId(Long id) { this.id = id; }
  public void setCampagne(Donateur campagne) { this.campagne = campagne; }
  public void setNomDonateur(String nomDonateur) { this.nomDonateur = nomDonateur; }
  public void setMontant(Double montant) { this.montant = montant; }
  public void setDate(LocalDate date) { this.date = date; }
}

