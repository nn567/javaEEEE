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
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author anastasia.salari
 */
@Local
public interface HistoriqueEEquipeFacadeLocal {

    void create(HistoriqueEEquipe historiqueEEquipe);

    void edit(HistoriqueEEquipe historiqueEEquipe);

    void remove(HistoriqueEEquipe historiqueEEquipe);

    HistoriqueEEquipe find(Object id);

    List<HistoriqueEEquipe> findAll();

    List<HistoriqueEEquipe> findRange(int[] range);

    int count();

    void creerHEE(Entraineur entraineur, Equipe equipe);

    List<HistoriqueEEquipe> recupHE(Entraineur e, Equipe eq);

    void majHEE(long id);

    HistoriqueEEquipe recupDernierHE(Entraineur e);

    Entraineur rechercherEntraineurActuel(Equipe equipe);
    
}
