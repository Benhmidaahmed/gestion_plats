package com.example.gestion_plats.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestion_plats.entities.Cuisinier;
import com.example.gestion_plats.entities.Plat;
import com.example.gestion_plats.service.TraiteurService;

//import ch.qos.logback.core.net.server.Client;
import com.example.gestion_plats.entities.Client;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")

public class TraiteurController {
    @Autowired
    private TraiteurService traiteurService;

    @PostMapping("/clients")
    public Client ajouterClient(@RequestBody Client client) {
        return traiteurService.ajouterClient(client);
    }

    @PostMapping("/cuisiniers")
    public void ajouterCuisinier(@RequestBody Cuisinier cuisinier) {
        traiteurService.ajouterCuisinier(cuisinier);
    }

    @PostMapping("/plats/{idClient}/{idCuisinier}")
    public void ajouterPlat(@RequestBody Plat plat,
                            @PathVariable Integer idClient,
                            @PathVariable Integer idCuisinier) {
        traiteurService.ajouterPlatAffecterClientEtCuisinier(plat, idClient, idCuisinier);
    }

    @GetMapping("/plats")
    public List<Plat> afficherPlats(@RequestParam String nom, @RequestParam String prenom) {
        return traiteurService.AfficherListePlatsParClient(nom, prenom);
    }

    @GetMapping("/montant/{idClient}")
    public float montantApayer(@PathVariable Integer idClient) {
        return traiteurService.MontantApayerParClientInteger(idClient);
    }

    @PutMapping("/imc/{idClient}")
    public void modifierImc(@PathVariable Integer idClient) {
        traiteurService.ModifierImc(idClient);
    }
}
