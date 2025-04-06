package com.example.gestion_plats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestion_plats.entities.Cuisinier;
@Repository
public interface CuisinierRepository extends JpaRepository <Cuisinier,Integer> {
    
}
