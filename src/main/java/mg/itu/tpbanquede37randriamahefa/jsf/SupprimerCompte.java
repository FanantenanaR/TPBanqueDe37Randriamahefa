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
import mg.itu.tpbanquede37randriamahefa.jsf.util.Util;
import mg.itu.tpbanquede37randriamahefa.service.GestionnaireCompte;

/**
 *
 * @author USER
 */
@Named(value = "supprimerCompte")
@ViewScoped
public class SupprimerCompte implements Serializable {

    @Inject
    GestionnaireCompte gestionCompte;
    
    private Long idCompte;
    private CompteBancaire compte;
    
    /**
     * Creates a new instance of SupprimerCompte
     */
    public SupprimerCompte() {
    }

    public Long getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(Long idCompte) {
        this.idCompte = idCompte;
    }

    public CompteBancaire getCompte() {
        return compte;
    }

    public void setCompte(CompteBancaire compte) {
        this.compte = compte;
    }
    
    public void loadCompte() {
        this.compte = gestionCompte.getById(idCompte);
    }
    
    public String supprimerCompte() {
        System.out.println("test");
        gestionCompte.supprimer(compte);
        Util.addFlashInfoMessage("Compte " + compte.getNom()+ " supprimé avec succès.");
        return "listeComptes?faces-redirect=true";
    }
    
}
