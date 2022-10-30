package com.example.demo.entities;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name ="Equipe")
public class Equipe {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEquipe")
    private Long idEquipe;
    private String nom;
    private String specialite;
    @ManyToOne
    Entreprise entreprise;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Projet> projets;
}
