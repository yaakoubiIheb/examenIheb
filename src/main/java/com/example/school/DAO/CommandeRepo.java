package com.example.school.DAO;

import com.example.school.entities.Client;
import com.example.school.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeRepo extends JpaRepository<Commande, Long> {

    @Query("SELECT COUNT(cmd) FROM Commande cmd WHERE cmd.client = :client")
    int countByClient(@Param("client") Client client);


    @Query("SELECT COUNT(lc) FROM Ligne_commande lc WHERE lc.commande = :commande")
    int countProduitsByCommande(@Param("commande") Commande commande);


    @Query("SELECT SUM(lc.quantite) FROM Ligne_commande lc JOIN lc.commande cmd WHERE cmd.client = :client")
    int sumProduitsOrderedByClient(@Param("client") Client client);
}



