package com.example.gestion_plats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestion_plats.entities.*;
@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    
}
