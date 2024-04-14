/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.tpbanquede37randriamahefa.config;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.servlet.ServletContext;
import jakarta.transaction.Transactional;
import mg.itu.tpbanquede37randriamahefa.entity.CompteBancaire;
import mg.itu.tpbanquede37randriamahefa.service.GestionnaireCompte;

/**
 *
 * @author USER
 */
@Named(value = "init")
@ApplicationScoped
public class Init {
    
    @Inject
    GestionnaireCompte gestionCompte;

    /**
     * Creates a new instance of Init
     */
    public Init() {
    }

    @PostConstruct
    @Transactional
    public void init(
            @Observes
            @Initialized(ApplicationScoped.class) ServletContext context) {
        long nombre = gestionCompte.nbComptes();
        if (nombre == 0) {
            gestionCompte.creerCompte(new CompteBancaire("John Lennon", 150000));
            gestionCompte.creerCompte(new CompteBancaire("Paul McCartney", 950000));
            gestionCompte.creerCompte(new CompteBancaire("Ringo Starr", 20000));
            gestionCompte.creerCompte(new CompteBancaire("Georges Harrisson", 100000));
        }
    }
    
}
