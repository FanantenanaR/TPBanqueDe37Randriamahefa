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
@Named(value = "modifierCompte")
@ViewScoped
public class ModifierCompte implements Serializable {
    
    @Inject
    GestionnaireCompte gestionCompte;
    
    private Long idCompte;
    private CompteBancaire compte;

    /**
     * Creates a new instance of ModifierCompte
     */
    public ModifierCompte() {
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
    
    public String appliquerChangement() {
        gestionCompte.update(compte);
        return "listeComptes?faces-redirect=true";
    }
}
