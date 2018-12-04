/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entites.Arbitre;
import Entites.Equipe;
import Entites.Match1;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author anastasia.salari
 */
@Local
public interface Match1FacadeLocal {

    void create(Match1 match1);

    void edit(Match1 match1);

    void remove(Match1 match1);

    Match1 find(Object id);

    List<Match1> findAll();

    List<Match1> findRange(int[] range);

    int count();
    void creerMatch(Date date, String heureMin,int butE1, int butE2, Arbitre a, Equipe e1, Equipe e2 );

    void modifierMatch(Date date, String eq1, String eq2);

    List<Match1> recupMatchsArbitre(Arbitre a);

    List<Match1> recupMatchsEquipe(Equipe e);
    
}
