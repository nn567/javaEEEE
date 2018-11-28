/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import Entites.Arbitre;
import Entites.Entraineur;
import Entites.Equipe;
import Entites.FauteComise;
import Entites.HistoriqueEEquipe;
import Entites.HistoriqueJEquipe;
import Entites.Joueur;
import Entites.Match1;
import Facade.ArbitreFacadeLocal;
import Facade.EntraineurFacadeLocal;
import Facade.EquipeFacadeLocal;
import Facade.FauteComiseFacadeLocal;
import Facade.HistoriqueEEquipeFacadeLocal;
import Facade.JoueurFacadeLocal;
import Facade.Match1FacadeLocal;
import gestion.gestionFederationLocal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author anastasia.salari
 */
@Stateless
public class gestionFederation implements gestionFederationLocal {

    @EJB
    private Match1FacadeLocal match1Facade;

    @EJB
    private FauteComiseFacadeLocal fauteComiseFacade;

    @EJB
    private JoueurFacadeLocal joueurFacade;


    @EJB
    private HistoriqueEEquipeFacadeLocal historiqueEEquipeFacade;

    @EJB
    private EntraineurFacadeLocal entraineurFacade;

    @EJB
    private EquipeFacadeLocal equipeFacade;

    @EJB
    private ArbitreFacadeLocal arbitreFacade;
    
    
    
    

    @Override
    public void creerEquipe(String nom) {
        equipeFacade.creerEquipe(nom, 0);
    }

    @Override
    public void creerArbitre(String n, String p, String l, String m) {
        arbitreFacade.creerArbitre(n, p, l, m);
    }

    @Override
    public void affecterEE(String n, String p, String nomE) {
        
        Entraineur e = entraineurFacade.rechercheEntraineur(n, p);
        Equipe eq = equipeFacade.rechercheEquipe(n);
        if (e!=null && eq!=null)
        historiqueEEquipeFacade.creerHEE(new Date(), null, e, eq);
    }

    
  @Override
   public void creerMatch(String eq1, String eq2, long id, String date) {
        Equipe equipe1 = equipeFacade.rechercheEquipe(eq1);
        Equipe equipe2 = equipeFacade.rechercheEquipe(eq2);

        Arbitre a = arbitreFacade.rechercheArbitreId(id);
        boolean b1=false;
        boolean b2 = false;
        boolean b3 = false;
        
        List<Match1> liste = match1Facade.recupMatchsArbitre(a);

        List<Match1> listeME1 = match1Facade.recupMatchsEquipe(equipe1);
        
        List<Match1> listeME2 = match1Facade.recupMatchsEquipe(equipe2);
        
        
       Date d = java.sql.Date.valueOf(date);
       
     
        if (equipe1 != null && equipe2 != null && a != null && d != null) {

            if (!liste.isEmpty()) //on vérifie d'abord la dispo de l'arbitre
            {
                for (Match1 m : liste) {
                    if (!m.getDate().equals(d)) {
                        b1 = false;
                    } else {
                        b1 = true;
                    }
                }
            } else {
                b1 = true;
            }

            if (!listeME1.isEmpty()) //vérification si la 1ere equipe a des matchs
            {
                for (Match1 m : listeME1) // on récupère les matchs de l'équipe 1
                {
                    if (!m.getDate().equals(d)) //on vérifie la date du match de l'equipe 1
                    {
                        b2 = false;
                    } else {
                        b2 = true;
                    }
                }
            } else {
                b2 = true;
            }

            if (!listeME2.isEmpty()) {
                for (Match1 m1 : listeME2) {
                    if (!m1.getDate().equals(d)) {
                        b3 = false;
                    } else {
                        b3 = true;
                    }
                }
            } else {
                b3 = true;
            }

            if (b1&&b2&&b3)
            {
                match1Facade.creerMatch(d, 0, 0, a, equipe1, equipe2);
            }
        }

    }

    @Override
    public void interdiction(String n, String p, String date) {
        Joueur j = joueurFacade.rechercheJoueur(n, p);
        if (j!=null)
        {
        if (j.getDateInterdiction()!=null)
            j.setDateInterdiction(new Date(date));
        }
    }

 
    @Override
    public List<FauteComise> afficherFautesArbitre(String n, String p) {
        Arbitre a = arbitreFacade.rechercheArbitre(n, p);
        List<Match1> listeM = match1Facade.recupMatchsArbitre(a);
        List<FauteComise> liste  = new ArrayList<FauteComise>();
        for (Match1 m : listeM)
        {
             List<FauteComise> listeFC = fauteComiseFacade.recupFautesMatch(m);
             for (FauteComise FC : listeFC)
             {
                 liste.add(FC);
             }
        }
       return liste;
               
    }

    @Override
    public List<Equipe> recupEquipes() {
        return equipeFacade.recupEquipes();
    }

    @Override
    public List<Arbitre> recupArbitres() {
        return arbitreFacade.recupArbitres();
    }
    
    
    
    
    
    

}
