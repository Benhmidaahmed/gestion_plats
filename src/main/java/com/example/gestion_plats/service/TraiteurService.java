package com.example.gestion_plats.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.gestion_plats.entities.Client;
import com.example.gestion_plats.entities.Cuisinier;
import com.example.gestion_plats.entities.Plat;
import com.example.gestion_plats.enums.Categorie;
import com.example.gestion_plats.enums.Imc;
import com.example.gestion_plats.repository.ClientRepository;
import com.example.gestion_plats.repository.CuisinierRepository;
import com.example.gestion_plats.repository.PlatRepository;
//import com.example.gestion_plats.enums.Categorie;

@Service
public class TraiteurService {
    @Autowired private ClientRepository clientRepo;
    @Autowired private CuisinierRepository cuisRepo;
    @Autowired private PlatRepository platRepo;
    public Client ajouterClient(Client client)
    {
        return clientRepo.save(client);
    }
    public void ajouterCuisinier(Cuisinier cuisinier)
    {
        cuisRepo.save(cuisinier);

    }
    public void ajouterPlatAffecterClientEtCuisinier(Plat plat, Integer idClient, Integer idCuisinier)
    {
        Client client =clientRepo.findById(idClient).orElseThrow();
        Cuisinier cuisinier=cuisRepo.findById(idCuisinier).orElseThrow();
        long nbPrincipale =0;
        for (Plat plat1: client.getPlats())
        {
            if (plat1.getCategory()== Categorie.PRINCIPAL)
            {
                nbPrincipale++;
            }
        }
        if (plat.getCategory() != Categorie.PRINCIPAL|| nbPrincipale<2)
        {
            plat.setClient(client);
            plat.getCuisiniers().add(cuisinier);
            platRepo.save(plat);
        }
    }
    public List <Plat> AfficherListePlatsParClient(String nom, String prenom)
    {
        return platRepo.findByClientNomAndClientPrenom(nom, prenom);

    }
    public float MontantApayerParClientInteger (Integer idclient)
    {
        Client client =clientRepo.findById(idclient).orElseThrow();
        Float total=0f;
        for (Plat plat : client.getPlats())
        {
            total+=plat.getPrix();
        }
        return total;

    }
    public void ModifierImc(Integer idclient)
    {
        Client client =clientRepo.findById(idclient).orElseThrow();
        int totalCalories =0;
        for (Plat plat : client.getPlats())
        {
            totalCalories+=plat.getCalories();
        }
        if (totalCalories <2000)
        {
            client.setImc(Imc.FAIBLE);
        }
        else if (totalCalories==2000)
        {
            client.setImc(Imc.IDEAL);
        }
        else {
            client.setImc(Imc.FORT);
        }
        clientRepo.save(client);

    }
    @Scheduled(fixedRate = 15000)
    public void AffichierListeCuisinier() {
        List<Cuisinier> all = cuisRepo.findAll();
        all.stream()
            .filter(c -> c.getPlats().stream()
                .filter(p -> p.getCategory() == Categorie.PRINCIPAL)
                .count() >= 2)
            .forEach(c -> System.out.println(c.getNom() + " " + c.getPrenom()));
    }

}
