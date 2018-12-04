/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entites.Arbitre;
import Entites.Joueur;
import Entites.Match1;
import java.util.ArrayList;
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
public class ArbitreFacade extends AbstractFacade<Arbitre> implements ArbitreFacadeLocal {

    @PersistenceContext(unitName = "GestionM-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArbitreFacade() {
        super(Arbitre.class);
    }

    @Override
    public void creerArbitre(String nom, String prenom, String login, String mdp) {
        Arbitre a = new Arbitre();
        a.setNom(nom);
        a.setPrenom(prenom);
        a.setLogin(login);
        a.setMdp(mdp);
        a.setMatchs(new ArrayList<Match1>());
        em.persist(a);
    }

    @Override
    public Arbitre authen(String log, String mdp) {    
        Query requete = em.createQuery("SELECT a from Arbitre as a where a.login=:lo and a.mdp=:m");
        requete.setParameter("lo", log);
        requete.setParameter("m", mdp);       
        List<Arbitre> liste =  requete.getResultList();
        if (!liste.isEmpty())
            return liste.get(0);
        else return null;
    }

    @Override
    public Arbitre rechercheArbitre(String n, String p) {
        Query requete = em.createQuery("SELECT j from Arbitre as j where j.nom=:nom and j.prenom=:pre");
        requete.setParameter("nom", n);
        requete.setParameter("pre", p);       
        List<Arbitre> liste =  requete.getResultList();
        if (!liste.isEmpty())
            return liste.get(0);
        else return null;
    }

    @Override
    public List<Arbitre> recupArbitres() {
        Query requete = em.createQuery("SELECT j from Arbitre as j");     
        List<Arbitre> liste =  requete.getResultList();
        return liste;
    }

    @Override
    public Arbitre rechercheArbitreId(long id) {
         Query requete = em.createQuery("SELECT j from Arbitre as j where j.id=:i");
        requete.setParameter("i", id);
          
        List<Arbitre> liste =  requete.getResultList();
        if (!liste.isEmpty())
            return liste.get(0);
        else return null;
    }
    
    


    
    
    
    
    
}
