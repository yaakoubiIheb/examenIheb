package com.example.school.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Ligne_commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id_L;

    private int quantite;

    @OneToOne(mappedBy = "ligne_commande")
    private Produits produit;

    @OneToOne(mappedBy = "ligne_commande")
    private Commande commande;



}
