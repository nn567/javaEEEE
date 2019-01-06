/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import Entites.Entraineur;
import Entites.Equipe;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Meiji
 */
@Local
public interface gestionPublicLocal {

    List afficherMatchDate(Date date);

    List afficherMatchIntervalleDate(Date datedebut, Date datefin);

    List afficherMatchEquipe(Equipe equipe);

    Equipe rechercherEquipeNom(String nom);

    List recupListeEquipes();

    Entraineur rechercherEntraineurActuel(Equipe equipe);

    List afficherClassement();

    List afficherComposition();
    
}
