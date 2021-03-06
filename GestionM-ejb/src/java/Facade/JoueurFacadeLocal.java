/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entites.FauteComise;
import Entites.HistoriqueJEquipe;
import Entites.Joueur;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author anastasia.salari
 */
@Local
public interface JoueurFacadeLocal {

    void create(Joueur joueur);

    void edit(Joueur joueur);

    void remove(Joueur joueur);

    Joueur find(Object id);

    List<Joueur> findAll();

    List<Joueur> findRange(int[] range);

    int count();

    void creerJoueur(String nom, String prenom);

    void supprimerJoueur(Joueur j);

    Joueur rechercheJoueur(String n, String p);

    List<Joueur> recupJoueurs();

    Joueur rechercheJoueurId(long id);

    void sanctionnerJ(long id, Date d);
    
}
