/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entites.Entraineur;
import Entites.Equipe;
import Entites.HistoriqueEEquipe;
import Entites.HistoriqueJEquipe;
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
public class EquipeFacade extends AbstractFacade<Equipe> implements EquipeFacadeLocal {

    @PersistenceContext(unitName = "GestionM-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EquipeFacade() {
        super(Equipe.class);
    }

    @Override
    public void creerEquipe(String nomE,int points) {
        Equipe e = new Equipe();
        e.setNomE(nomE);
        e.setPoints(points);
        e.setHistoriqueJE(new ArrayList<HistoriqueJEquipe>());
        e.setHistoriqueEEquipes(new ArrayList<HistoriqueEEquipe>());
        em.persist(e);
    }

    @Override
    public Equipe rechercheEquipe(String n) {
       Query requete = em.createQuery("SELECT j from Equipe as j where j.nomE=:nom");
        requete.setParameter("nom", n);      
        List<Equipe> liste =  requete.getResultList();
        if (!liste.isEmpty())
            return liste.get(0);
        else return null; 
    }

    @Override
    public List<Equipe> recupEquipes() {
        Query requete = em.createQuery("SELECT j from Equipe as j");   
        List<Equipe> liste =  requete.getResultList();
        return liste;
    }

    @Override
    public List afficherClassement() {
        Query requete = em.createQuery("SELECT e from Equipe as e order by e.points desc");   
       return requete.getResultList();
    }
    
    
    
    
    
}
