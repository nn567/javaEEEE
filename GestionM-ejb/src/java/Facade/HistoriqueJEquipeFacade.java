/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entites.Equipe;
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
public class HistoriqueJEquipeFacade extends AbstractFacade<HistoriqueJEquipe> implements HistoriqueJEquipeFacadeLocal {

    @PersistenceContext(unitName = "GestionM-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HistoriqueJEquipeFacade() {
        super(HistoriqueJEquipe.class);
    }

    @Override
    public void creerHJE(Date dateD, Date dateF, Joueur joueur, Equipe equipe) {
        HistoriqueJEquipe hje = new HistoriqueJEquipe();
        hje.setDateDebut(dateD);
        hje.setDateFin(dateF);
        hje.setJoueur(joueur);
        hje.setEquipe(equipe);
        em.persist(hje);
    }

    @Override
    public List afficherCompositionActuelle() {
        Query requete = em.createQuery("SELECT h from HistoriqueJEquipe as h where h.dateFin is null");    
        List<HistoriqueJEquipe> liste =  requete.getResultList();
        if (!liste.isEmpty())
            return liste;
        else return null;
    }

    

    
    
    
    
}
