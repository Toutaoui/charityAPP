package org.example.charityapp.entities;

import jakarta.persistence.*;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class usr{
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long ID;
   private String firstname;
   private String lastname;
   private String email;
   private String password;
   private String phone;
    @Column(unique=true, nullable=false, length=8, updatable = false)
   private String CIN;

}
