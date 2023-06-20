package com.example.school.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Produits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id_p;
    private String designation;
    private String description;
    private String categorie;
    private boolean disponibilite;
    private int quantitie;
    private double prix;


}
