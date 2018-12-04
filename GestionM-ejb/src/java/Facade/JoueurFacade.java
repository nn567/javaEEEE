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
import java.util.ArrayList;
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

    @PersistenceContext(unitName = "GestionM-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JoueurFacade() {
        super(Joueur.class);
    }

    @Override
    public void creerJoueur(String nom, String prenom) {
        Joueur j = new Joueur();
        j.setNom(nom);
        j.setPrenom(prenom);
        j.setFauteComises(new ArrayList<FauteComise>());
        j.setHistoriqueJEquipes(new ArrayList<HistoriqueJEquipe>() );
        j.setDateInterdiction(null);
        em.persist(j);
    }
    // a.setMatchs(new ArrayList<Match1>());

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

    
    
    @Override
    public List<Joueur> recupJoueurs() {
        Query requete = em.createQuery("SELECT j from Joueur as j");     
        List<Joueur> liste =  requete.getResultList();
        return liste;
    }

    @Override
    public Joueur rechercheJoueurId(long id) {
       Query requete = em.createQuery("SELECT j from Joueur as j where j.id:=id");
        requete.setParameter("id", id);      
        List<Joueur> liste =  requete.getResultList();
        if (!liste.isEmpty())
            return liste.get(0);
        else return null;
    }

    @Override
    public void sanctionnerJ(long id, Date d) {
         Query requete = em.createQuery("SELECT j from Joueur as j where j.id:=id");
         Joueur j = new Joueur();
        requete.setParameter("id", id);      
        List<Joueur> liste =  requete.getResultList();
        if (!liste.isEmpty())
           j = liste.get(0);
        j.setDateInterdiction(d);
        em.merge(j);
    
    }
    
    
    
    
    
    
}
