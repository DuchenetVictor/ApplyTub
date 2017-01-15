package com.example.iem.projecttub.POJO;

import com.example.iem.projecttub.Controller.MyDatabase;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.List;

/**
 * Created by iem on 04/11/2016.
 */
//// TODO: 15/01/2017 https://guides.codepath.com/android/DBFlow-Guide
// TODO: 15/01/2017 faire schema sqlite

@Table(database = MyDatabase.class)
public class Arret extends BaseModel {
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
