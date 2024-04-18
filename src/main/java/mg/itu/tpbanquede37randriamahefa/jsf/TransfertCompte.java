/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.tpbanquede37randriamahefa.jsf;

import jakarta.enterprise.context.RequestScoped;
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
@Named(value = "transfertCompte")
@RequestScoped
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

    public String effectuerTransfert() {

        if (idEnvoyeur == null || idEnvoyeur == 0) {
            Util.messageErreur("Champs non remplis", "Aucun envoyeur n'a été saisi.");
            return null;
        }
        if (idDestinataire == null || idDestinataire == 0) {
            Util.messageErreur("Champs non remplis", "Aucun destinataire n'a été saisi.");
            return null;
        }
        
        CompteBancaire envoyeur = gestionCompte.getById(idEnvoyeur);
        if (envoyeur == null) {
            Util.messageErreur("Client introuvable", "Aucun envoyeur correspond à l'ID saisi.");
            return null;
        }
        CompteBancaire destinataire = gestionCompte.getById(idDestinataire);
        if (destinataire == null) {
            Util.messageErreur("Client introuvable", "Aucun destinataire correspond à l'ID saisi.");
            return null;
        }
        if (montant > envoyeur.getSolde()) {
            Util.messageErreur("Montant invalide", "Le montant saisi excède la solde de l'envoyeur.");
            return null;
        }
        gestionCompte.transferer(envoyeur, destinataire, montant);
        return "listeComptes";
    }

}
