package com.example.demo.repository;

import com.example.demo.entities.Entreprise;
import com.example.demo.entities.Equipe;
import com.example.demo.entities.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRepository extends JpaRepository <Projet, Long > {
    List<Projet> findByProjectDetailTechnologieLike(String technologie);
    List<Projet> findByEquipeIdEquipe (Long idEquipe);
    List<Projet> findByEquipeIdEquipeAndProjectDetailDescriptionNull (Long idEquipe);
    List<Projet> findByEquipesIdEquipeAndEntrepriseIdEntreprise(Long idEquipe,Long idEntreprise) ;
    List<Projet> findbyEquipesSpecialiteAndEquipesEntrepriseAdresseLike(String specialite,String adresse);

    @Query("SELECT e FROM Entreprise.Equipe e WHERE e.specialite = ?1")
    List<Entreprise> retrieveEntreprisesBySpeciality(String speciality);

    @Query("SELECT pd FROM Projet.projectDetail pd  WHERE pd.technology = :t and pd.cout_provisoire > :c")
    List<Projet> retrieveSpecifiedProject(@Param("t") String technologie , @Param("c") Long price);

    @Query("SELECT p FROM Projet p WHERE p.projectDetail.technology= :t and p.projectDetail.dateDebut=0")
    List<Equipe> retrieveEquipebyTechnologieAndDate(@Param("t") String tech);

    @Query(value = "select * from Entreprise.Equipe ee where  ee.specialite=?1",nativeQuery = true)
    List<Entreprise> retrieveEntreprisesBySpeciality2(String speciality);

    @Query(value = "select * from  Projet.projectDetail pp where pd.technology = :t and pd.cout_provisoire > :c",nativeQuery = true)
    List<Projet> retrieveSpecifiedProject2(@Param("t") String technologie , @Param("c") Long price);

    @Query(value = "select * from Projet e where e.projectDetail.technology= :pt and  e.projectDetail.dateDebut=0",nativeQuery = true)
    List<Equipe> retrieveEquipebyTechnologieAndDate2(@Param("pt") String tech);
}
