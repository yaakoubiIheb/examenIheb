package com.example.school.Controles;


import com.example.school.DAO.ClientRepo;
import com.example.school.DAO.CommandeRepo;
import com.example.school.DAO.ProduitRepo;
import com.example.school.entities.Client;
import com.example.school.entities.Commande;
import com.example.school.entities.Produits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ControlService {

    private final ClientRepo clientRepository;
    private final CommandeRepo commandeRepository;
    private final ProduitRepo produitsRepository;

    @Autowired
    public ControlService(ClientRepo clientRepository, CommandeRepo commandeRepository,
                          ProduitRepo produitsRepository) {
        this.clientRepository = clientRepository;
        this.commandeRepository = commandeRepository;
        this.produitsRepository = produitsRepository;
    }

    // Get the number of commandes by a given client
    public int getNumberOfCommandesByClient(Client client) {
        return commandeRepository.countByClient(client);
    }


    public int getNumberOfProduitsInCommande(Commande commande) {
        return commandeRepository.countProduitsByCommande(commande);
    }


    public Client getMostLoyalClient() {
        List<Client> clients = clientRepository.findAll();
        Client mostLoyalClient = null;
        int maxProduitsOrdered = 0;

        for (Client client : clients) {
            int produitsOrdered = commandeRepository.sumProduitsOrderedByClient(client);
            if (produitsOrdered > maxProduitsOrdered) {
                maxProduitsOrdered = produitsOrdered;
                mostLoyalClient = client;
            }
        }

        return mostLoyalClient;
    }


    public List<Client> getClientsWithoutCommande() {
        return clientRepository.findClientsWithoutCommande();
    }


    public Produits getMostRequestedProduct() {
        List<Produits> produits = produitsRepository.findAll();
        Produits mostRequestedProduct = null;
        int maxCommandes = 0;

        for (Produits produit : produits) {
            int commandesCount = produitsRepository.countCommandesByProduit(produit);
            if (commandesCount > maxCommandes) {
                maxCommandes = commandesCount;
                mostRequestedProduct = produit;
            }
        }

        return mostRequestedProduct;
    }
}
