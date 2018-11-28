/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entites.Arbitre;
import Entites.FauteComise;
import Entites.HistoriqueJEquipe;
import Entites.Joueur;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author anastasia.salari
 */
@Stateless
public class JoueurFacade extends AbstractFacade<Joueur> implements JoueurFacadeLocal {

    @PersistenceContext(unitName = "GestionMatch-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JoueurFacade() {
        super(Joueur.class);
    }

    @Override
    public void creerJoueur(String nom, String prenom, List<FauteComise> listeF, List<HistoriqueJEquipe> histoE, Date dateI) {
        Joueur j = new Joueur();
        j.setNom(nom);
        j.setPrenom(prenom);
        j.setFauteComises(listeF);
        j.setHistoriqueJEquipes(histoE);
        j.setDateInterdiction(dateI);
        em.persist(j);
    }

    @Override
    public void supprimerJoueur(Joueur j) {
        em.remove(j);
    }

    @Override
    public Joueur rechercheJoueur(String n, String p) {
        Query requete = em.createQuery("SELECT j from Joueur as j where j.nom=:nom and j.prenom=:pre");
        requete.setParameter("nom", n);
        requete.setParameter("pre", p);       
        List<Joueur> liste =  requete.getResultList();
        if (!liste.isEmpty())
            return liste.get(0);
        else return null;
    }
    
    
    
    
}
