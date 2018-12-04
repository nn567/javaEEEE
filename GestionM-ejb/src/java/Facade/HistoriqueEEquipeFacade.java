/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entites.Entraineur;
import Entites.Equipe;
import Entites.HistoriqueEEquipe;
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
public class HistoriqueEEquipeFacade extends AbstractFacade<HistoriqueEEquipe> implements HistoriqueEEquipeFacadeLocal {

    @PersistenceContext(unitName = "GestionM-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HistoriqueEEquipeFacade() {
        super(HistoriqueEEquipe.class);
    }

    @Override
    public void creerHEE(Entraineur entraineur, Equipe equipe) {
        HistoriqueEEquipe HEE  = new HistoriqueEEquipe();
        HEE.setDateDebut(new Date());
        HEE.setDateFin(null);
        HEE.setEntraineur(entraineur);
        HEE.setEquipe(equipe);
        em.persist(HEE);
    }

    @Override
    public List<HistoriqueEEquipe> recupHE(Entraineur e, Equipe eq) {
        Query requete = em.createQuery("SELECT j from HistoriqueEEquipe as j where j.entraineur:=ent  and j.equipe:=e");
        requete.setParameter("ent", e);     
        requete.setParameter("e", eq);
        List<HistoriqueEEquipe> liste =  requete.getResultList();
        if (!liste.isEmpty())
            return liste;
        else return null;
    }

    @Override
    public void majHEE(long id) {
        Query requete = em.createQuery("SELECT j from HistoriqueEEquipe as j where j.id:=id");
        requete.setParameter("id", id);       
        List<HistoriqueEEquipe> liste =  requete.getResultList();
        if (liste.isEmpty())
        {
            
        }
        else {
            HistoriqueEEquipe h = liste.get(0);
            h.setDateFin(new Date());
            em.merge(h);
        }
            
    }

    @Override
    public HistoriqueEEquipe recupDernierHE(Entraineur e) {
        Query requete = em.createQuery("SELECT j from HistoriqueEEquipe as j where j.entraineur:=ent and j.dateFin is null");
        requete.setParameter("ent", e);     
        List<HistoriqueEEquipe> liste =  requete.getResultList();
        if (!liste.isEmpty())
            return liste.get(0);
        else return null;
    }
    
    
    
    
    
    
}
