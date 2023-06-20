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


public class Client {
    @Id
    @GeneratedValue
    private long id_cl;

    private String nom;
    private String prenom;


}
