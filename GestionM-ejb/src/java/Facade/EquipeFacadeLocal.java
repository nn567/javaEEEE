/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entites.Equipe;
import Entites.HistoriqueEEquipe;
import Entites.HistoriqueJEquipe;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author anastasia.salari
 */
@Local
public interface EquipeFacadeLocal {

    void create(Equipe equipe);

    void edit(Equipe equipe);

    void remove(Equipe equipe);

    Equipe find(Object id);

    List<Equipe> findAll();

    List<Equipe> findRange(int[] range);

    int count();

    void creerEquipe(String nomE, int points);

    Equipe rechercheEquipe(String n);

    List<Equipe> recupEquipes();

    List afficherClassement();
    
}
