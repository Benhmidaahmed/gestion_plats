package com.example.gestion_plats.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gestion_plats.entities.*;

public interface PlatRepository extends JpaRepository <Plat,Integer> {
    List<Plat> findByClientNomAndPrenom(String nom, String prenom);
    
}
