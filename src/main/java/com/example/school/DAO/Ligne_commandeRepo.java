package com.example.school.DAO;

import com.example.school.entities.Client;
import com.example.school.entities.Ligne_commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Ligne_commandeRepo extends JpaRepository<Ligne_commande, Long> {

}
