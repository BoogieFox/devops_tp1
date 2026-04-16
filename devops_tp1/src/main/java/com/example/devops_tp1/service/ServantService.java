package com.example.devops_tp1.service;

import com.example.devops_tp1.model.Servant;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServantService {

    private final List<Servant> servants = new ArrayList<>();

    public ServantService() {
        servants.add(new Servant("Artoria Pendragon", "Saber", 5));
        servants.add(new Servant("Gilgamesh", "Archer", 5));
        servants.add(new Servant("Cu Chulainn", "Lancer", 3));
        servants.add(new Servant("Medusa", "Rider", 3));
        servants.add(new Servant("Medea", "Caster", 3));
        servants.add(new Servant("Sasaki Kojirou", "Assassin", 1));
        servants.add(new Servant("Heracles", "Berserker", 4));
    }

    public List<Servant> getAllServants() {
        return servants;
    }

    public Optional<Servant> getServantByName(String name) {
        return servants.stream()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    public Servant addServant(Servant servant) {
        servants.add(servant);
        return servant;
    }
}
