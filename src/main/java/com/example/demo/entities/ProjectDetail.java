package com.example.demo.entities;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.Date;

@Entity
@Table(name="ProjectDetail")
public class ProjectDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPDetail")
    private Long idPDetail;
    private String description;
    private Long cout_provisoire;
    private Date dateDebut;
    private String technologie;

    @OneToOne(mappedBy="projectDetail")
    private Projet projet;
}
