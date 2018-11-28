/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entites.Faute;
import Entites.FauteComise;
import Entites.Joueur;
import Entites.Match1;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author anastasia.salari
 */
@Local
public interface FauteComiseFacadeLocal {

    void create(FauteComise fauteComise);

    void edit(FauteComise fauteComise);

    void remove(FauteComise fauteComise);

    FauteComise find(Object id);

    List<FauteComise> findAll();

    List<FauteComise> findRange(int[] range);

    int count();

    void creerFaute(Faute type, Joueur joueur, Match1 match);

    List<FauteComise> recupFautesMatch(Match1 m);
    
}
