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
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author anastasia.salari
 */
@Stateless
public class HistoriqueJEquipeFacade extends AbstractFacade<HistoriqueJEquipe> implements HistoriqueJEquipeFacadeLocal {

    @PersistenceContext(unitName = "GestionMatch-ejbPU")
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
    
    
}
