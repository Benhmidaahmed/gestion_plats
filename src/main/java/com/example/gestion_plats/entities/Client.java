package com.example.gestion_plats.entities;
//import scala.Int;
import jakarta.persistence.*;
import java.util.*;

import com.example.gestion_plats.enums.Imc;
import com.example.gestion_plats.entities.*;

@Entity
public class Client {
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String prenom;
    @Enumerated(EnumType.STRING)
    private Imc imc;
  @OneToMany(mappedBy = "client")
    private List<Plat> plats=new ArrayList<>();
// Getters/Setters
public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
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

public Imc getImc() {
    return imc;
}

public void setImc(Imc imc) {
    this.imc = imc;
}

public List<Plat> getPlats() {
    return plats;
}

public void setPlats(List<Plat> plats) {
    this.plats = plats;
}


    
}
