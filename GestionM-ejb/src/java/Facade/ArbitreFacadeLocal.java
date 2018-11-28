/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entites.Arbitre;
import Entites.Match1;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author anastasia.salari
 */
@Local
public interface ArbitreFacadeLocal {

    void create(Arbitre arbitre);

    void edit(Arbitre arbitre);

    void remove(Arbitre arbitre);

    Arbitre find(Object id);

    List<Arbitre> findAll();

    List<Arbitre> findRange(int[] range);

    int count();

    void creerArbitre(String nom, String prenom, String login, String mdp);

    Arbitre authen(String log, String mdp);

    Arbitre rechercheArbitre(String n, String p);

    List<Arbitre> recupArbitres();

    Arbitre rechercheArbitreId(long id);


    
}
