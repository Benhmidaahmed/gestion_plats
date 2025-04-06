package com.example.gestion_plats.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.*;
import java.util.*;
import java.util.Locale.Category;
@Entity
public class Cuisinier {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idCuisinier;
    private String nom;
    private String prenom ;
    @ManyToMany(mappedBy = "cuisiniers")
    private List <Plat> plats =new ArrayList <>();
    
    public Integer getIdCuisinier() {
        return idCuisinier;
    }

    public void setIdCuisinier(Integer idCuisinier) {
        this.idCuisinier = idCuisinier;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public List<Plat> getPlats() {
        return plats;
    }

    public void setPlats(List<Plat> plats) {
        this.plats = plats;
    }
}
