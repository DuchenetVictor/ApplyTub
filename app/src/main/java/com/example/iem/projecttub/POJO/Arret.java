package com.example.iem.projecttub.POJO;

import java.util.List;

/**
 * Created by iem on 04/11/2016.
 */

public class Arret {
    private String nom;
    private List<String>horaires;

    public Arret(String nom, List<String>horaires){
        this.nom = nom;
        this.horaires = horaires;
    }

    public String getNom() {
        return nom;
    }

    public List<String> getHoraires() {
        return horaires;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setHoraires(List<String> horaires) {
        this.horaires = horaires;
    }
}
