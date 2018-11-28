/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entites.Equipe;
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
public interface HistoriqueJEquipeFacadeLocal {

    void create(HistoriqueJEquipe historiqueJEquipe);

    void edit(HistoriqueJEquipe historiqueJEquipe);

    void remove(HistoriqueJEquipe historiqueJEquipe);

    HistoriqueJEquipe find(Object id);

    List<HistoriqueJEquipe> findAll();

    List<HistoriqueJEquipe> findRange(int[] range);

    int count();

    void creerHJE(Date dateD, Date dateF, Joueur joueur, Equipe equipe);
    
}
