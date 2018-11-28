/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entites.Arbitre;
import Entites.Entraineur;
import Entites.HistoriqueEEquipe;
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
public class EntraineurFacade extends AbstractFacade<Entraineur> implements EntraineurFacadeLocal {

    @PersistenceContext(unitName = "GestionMatch-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EntraineurFacade() {
        super(Entraineur.class);
    }

    @Override
    public void creerEntraineur(String nom, String prenom, String login, String mdp, List<HistoriqueEEquipe> histoEE) {
        Entraineur e = new Entraineur();
        e.setNom(nom);
        e.setPrenom(prenom);
        e.setLogin(login);
        e.setMdp(mdp);
        e.setHistoriqueEEquipes(histoEE);
        em.persist(e);
    }

    @Override
    public Entraineur authen(String log, String mdp) {
        Query requete = em.createQuery("SELECT e from Entraineur as e where e.login=:lo and e.mdp=:m");
        requete.setParameter("lo", log);
        requete.setParameter("m", mdp);       
        List<Entraineur> liste =  requete.getResultList();
        if (!liste.isEmpty())
            return liste.get(0);
        else return null;
    }

    @Override
    public Entraineur rechercheEntraineur(String n, String p) {
         Query requete = em.createQuery("SELECT j from Entraineur as j where j.nom=:nom and j.prenom=:pre");
        requete.setParameter("nom", n);
        requete.setParameter("pre", p);       
        List<Entraineur> liste =  requete.getResultList();
        if (!liste.isEmpty())
            return liste.get(0);
        else return null;
    }
    
    
    
    
}
