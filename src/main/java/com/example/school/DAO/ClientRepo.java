package com.example.school.DAO;

import com.example.school.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepo extends JpaRepository<Client, Long> {
    @Query("SELECT c FROM Client c WHERE NOT EXISTS (SELECT cmd FROM Commande cmd WHERE cmd.client = c)")
    List<Client> findClientsWithoutCommande();
}
