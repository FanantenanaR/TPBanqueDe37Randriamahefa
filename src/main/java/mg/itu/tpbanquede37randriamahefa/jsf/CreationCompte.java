/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.tpbanquede37randriamahefa.jsf;

import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import mg.itu.tpbanquede37randriamahefa.entity.CompteBancaire;
import mg.itu.tpbanquede37randriamahefa.service.GestionnaireCompte;

/**
 *
 * @author USER
 */
@Named(value = "creationCompte")
@ViewScoped
public class CreationCompte implements Serializable {
    
    @Inject
    GestionnaireCompte gestionCompte;
    
    private String nom;
    private int solde;

    /**
     * Creates a new instance of CreationCompte
     */
    public CreationCompte() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }
    
    public String ajouterCompte(){
        CompteBancaire compte = new CompteBancaire(this.nom, this.solde);
        gestionCompte.creerCompte(compte);
        return "listeComptes";
    }
    
    
}
