package com.example.school.DAO;

import com.example.school.entities.Produits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepo extends JpaRepository<Produits, String> {
    @Query("SELECT COUNT(lc.commande) FROM Ligne_commande lc WHERE lc.produit = :produit")
    int countCommandesByProduit(@Param("produit") Produits produit);
}
