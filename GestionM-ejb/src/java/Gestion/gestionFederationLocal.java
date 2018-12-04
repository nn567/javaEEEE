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
import Entites.Joueur;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author anastasia.salari
 */
@Local
public interface gestionFederationLocal {

    void creerEquipe(String nom);

    void creerArbitre(String n, String p, String l, String m);

    void affecterEE(long id, String nomE);

    boolean creerMatch(String eq1, String eq2, long id, Date d);

    void interdiction(String n, String p, String date);

    List<FauteComise> afficherFautesArbitre(String n, String p);

    List<Equipe> recupEquipes();

   List<Arbitre> recupArbitres();

    List<Joueur> recupJoueurs();

    void creerInterdiction(String id, String date);

    List<Entraineur> recupEntraineur();




    
}
