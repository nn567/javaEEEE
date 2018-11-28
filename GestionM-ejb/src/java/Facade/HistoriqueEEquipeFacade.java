/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entites.Entraineur;
import Entites.Equipe;
import Entites.HistoriqueEEquipe;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author anastasia.salari
 */
@Stateless
public class HistoriqueEEquipeFacade extends AbstractFacade<HistoriqueEEquipe> implements HistoriqueEEquipeFacadeLocal {

    @PersistenceContext(unitName = "GestionMatch-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HistoriqueEEquipeFacade() {
        super(HistoriqueEEquipe.class);
    }

    @Override
    public void creerHEE(Date dateD, Date dateF, Entraineur entraineur, Equipe equipe) {
        HistoriqueEEquipe HEE  = new HistoriqueEEquipe();
        HEE.setDateDebut(dateD);
        HEE.setDateFin(dateF);
        HEE.setEntraineur(entraineur);
        HEE.setEquipe(equipe);
        em.persist(HEE);
    }
    
    
    
}
