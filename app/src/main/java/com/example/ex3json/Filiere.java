package com.example.ex3json;

import java.io.Serializable;

public class Filiere implements Serializable {

    private String nom;
    private String nomComplet;
    private String niveau;
    private int nbModule;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public int getNbModule() {
        return nbModule;
    }

    public void setNbModule(int nbModule) {
        this.nbModule = nbModule;
    }
}
