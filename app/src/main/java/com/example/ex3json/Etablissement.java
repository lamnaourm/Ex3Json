package com.example.ex3json;

import java.io.Serializable;
import java.util.ArrayList;

public class Etablissement implements Serializable {

    private String nom;
    private String adresse;
    private ArrayList<Filiere> filieres=new ArrayList<>();

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public ArrayList<Filiere> getFilieres() {
        return filieres;
    }

    public void setFilieres(ArrayList<Filiere> filieres) {
        this.filieres = filieres;
    }
}
