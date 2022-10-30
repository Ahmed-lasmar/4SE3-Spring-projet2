package com.example.demo.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name ="Entreprise")
public class Entreprise {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEntreprise")
    private Long idEntreprise;
    private String nom;
    private String adresse;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="entreprise")
    private Set<Equipe> Equipe;
}
