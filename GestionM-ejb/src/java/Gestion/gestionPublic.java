/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import Entites.Entraineur;
import Entites.Equipe;
import Facade.EquipeFacadeLocal;
import Facade.HistoriqueEEquipeFacadeLocal;
import Facade.HistoriqueJEquipeFacadeLocal;
import Facade.Match1FacadeLocal;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Meiji
 */
@Stateless
public class gestionPublic implements gestionPublicLocal {

    @EJB
    private HistoriqueJEquipeFacadeLocal historiqueJEquipeFacade;

    @EJB
    private HistoriqueEEquipeFacadeLocal historiqueEEquipeFacade;

    @EJB
    private EquipeFacadeLocal equipeFacade;

    
    @EJB
    private Match1FacadeLocal match1Facade;

    @Override
    public List afficherMatchDate(Date date) {
         return match1Facade.afficherMatchDate(date);
    }

    @Override
    public List afficherMatchIntervalleDate(Date datedebut, Date datefin) {
        return match1Facade.afficherMatchIntervalleDate(datedebut, datefin);
    }

    @Override
    public List afficherMatchEquipe(Equipe equipe) {
        return match1Facade.afficherMatchEquipe(equipe);
    }

    @Override
    public Equipe rechercherEquipeNom(String nom) {
        return equipeFacade.rechercheEquipe(nom);
    }

    @Override
    public List recupListeEquipes() {
        return equipeFacade.recupEquipes();
    }

    @Override
    public Entraineur rechercherEntraineurActuel(Equipe equipe) {
        return historiqueEEquipeFacade.rechercherEntraineurActuel(equipe);
    }

    @Override
    public List afficherClassement() {
        return equipeFacade.afficherClassement();
    }

    @Override
    public List afficherComposition() {
        return historiqueJEquipeFacade.afficherCompositionActuelle();
    }
    
    
    
    
    
    
    
    

    
}
