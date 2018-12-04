/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entites.Arbitre;
import Entites.Equipe;
import Entites.Faute;
import Entites.FauteComise;
import Entites.Joueur;
import Entites.Match1;
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
public class Match1Facade extends AbstractFacade<Match1> implements Match1FacadeLocal {

    @PersistenceContext(unitName = "GestionM-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Match1Facade() {
        super(Match1.class);
    }
    
    @Override
    public void creerMatch(Date date, String heureMin, int butE1, int butE2, Arbitre a, Equipe e1, Equipe e2) {
        Match1 m = new Match1();
        m.setDate(date);
        m.setArbitre(a);
        m.setButsE1(butE2);
        m.setButsE2(butE2);
        m.setFautes(new ArrayList<FauteComise>());
        m.setCompoE1(new ArrayList<Joueur>());
        m.setCompoE2(new ArrayList<Joueur>());
        m.setEquipe1(e1);
        m.setEquipe2(e2);
        m.setHeureMinute(heureMin);
        em.persist(m);
    }

    @Override
    public void modifierMatch(Date date, String eq1, String eq2) {
      Match1 m = new Match1();  
    }

    @Override
    public List<Match1> recupMatchsArbitre(Arbitre a) {
        Query requete = em.createQuery("SELECT m from Match1 as m where m.arbitre=:arb");
        requete.setParameter("arb", a);     
        List<Match1> liste =  requete.getResultList();
        return liste;
      
    }

    @Override
    public List<Match1> recupMatchsEquipe(Equipe e) {
        Query requete = em.createQuery("SELECT m from Match1 as m where m.equipe1=:eq union SELECT m from Match1 as m where m.equipe2=:eq");
        requete.setParameter("eq", e);     
        List<Match1> liste =  requete.getResultList();
        return  liste;
    }

    @Override
    public List<Match1> recupMatchsFaute(Faute f) {
        Query requete = em.createQuery("SELECT m from Match1 as m where m.fautes:eq");
        requete.setParameter("fa", f);
        List<Match1> liste = requete.getResultList();
        return liste;
    }

    @Override
    public List<Match1> recupMatchsDate(Date d) {
         Query requete = em.createQuery("SELECT m from Match1 as m where m.date");
        requete.setParameter("da", d);
        List<Match1> liste = requete.getResultList();
        return liste;
    }
}
