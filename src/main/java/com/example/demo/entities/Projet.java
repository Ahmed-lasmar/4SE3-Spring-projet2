package com.example.demo.entities;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name="Projet")
public class Projet {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProject")
    private Long idProject;
    private String nom;
    private String sujet;
    @OneToOne
    private ProjectDetail projectDetail;
    @ManyToMany(mappedBy="projets", cascade = CascadeType.ALL)
    private Set<Equipe> equipe;
}
