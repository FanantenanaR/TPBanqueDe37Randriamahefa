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
@Named(value = "transfertCompte")
@ViewScoped
public class TransfertCompte implements Serializable {
    @Inject
    GestionnaireCompte gestionCompte;
    
    private Long idEnvoyeur;
    private Long idDestinataire;
    private int montant;

    /**
     * Creates a new instance of TransfertCompte
     */
    public TransfertCompte() {
    }

    public Long getIdEnvoyeur() {
        return idEnvoyeur;
    }

    public void setIdEnvoyeur(Long idEnvoyeur) {
        this.idEnvoyeur = idEnvoyeur;
    }

    public Long getIdDestinataire() {
        return idDestinataire;
    }

    public void setIdDestinataire(Long idDestinataire) {
        this.idDestinataire = idDestinataire;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }
    
    public String effectuerTransfert(){
        CompteBancaire envoyeur = gestionCompte.getById(idEnvoyeur);
        CompteBancaire destinataire = gestionCompte.getById(idDestinataire);
        gestionCompte.transferer(envoyeur, destinataire, montant);
        return "listeComptes";
    }
    
    
    
    
    
}
