package com.example.gestion_plats.entities;
// import jakarta.persistence.Id;
import jakarta.persistence.*;
import java.util.*;
import java.util.Locale.Category;
@Entity

public class Plat {
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idPlat;
    private String label;
    private Float prix ;
    private Float calories;
    @Enumerated (EnumType.STRING)
    private Category category;
    @ManyToOne
    private Client client;
    @ManyToMany
    private List <Cuisinier> cuisiniers=new ArrayList <> ();
    public Integer getIdPlat() {
        return idPlat;
    }

    public void setIdPlat(Integer idPlat) {
        this.idPlat = idPlat;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public Float getCalories() {
        return calories;
    }

    public void setCalories(Float calories) {
        this.calories = calories;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Cuisinier> getCuisiniers() {
        return cuisiniers;
    }

    public void setCuisiniers(List<Cuisinier> cuisiniers) {
        this.cuisiniers = cuisiniers;
    }
}
