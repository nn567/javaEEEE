/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entites.Arbitre;
import Entites.Faute;
import Entites.FauteComise;
import Entites.Joueur;
import Entites.Match1;
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
public class FauteComiseFacade extends AbstractFacade<FauteComise> implements FauteComiseFacadeLocal {

    @PersistenceContext(unitName = "GestionM-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FauteComiseFacade() {
        super(FauteComise.class);
    }

    @Override
    public void creerFaute(Faute type, Joueur joueur, Match1 match) {
        FauteComise FC = new FauteComise();
        FC.setFaute(type);
        FC.setJoueur(joueur);
        FC.setMatch(match);
        em.persist(FC);
    }

    @Override
    public List<FauteComise> recupFautesMatch(Match1 m) {
        Query requete = em.createQuery("SELECT f from FauteComise as f where f.match=:mat");
        requete.setParameter("mat", m);      
        List<FauteComise> liste =  requete.getResultList();
        return liste;
    }
    
    
}
