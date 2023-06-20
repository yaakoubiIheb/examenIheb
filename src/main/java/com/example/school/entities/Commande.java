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

public class Commande {

    @Id
    @GeneratedValue
    private Long id_c;
    private String date_c;

    @OneToMany(mappedBy = "commande")
    private List<Produits> produits;



    @ManyToOne
    @JoinColumn(name = "id_cl")
    private Client client;




    public int getProduitsCount() {
        return produits.size();
    }
}
