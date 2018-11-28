/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entites.Entraineur;
import Entites.HistoriqueEEquipe;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author anastasia.salari
 */
@Local
public interface EntraineurFacadeLocal {

    void create(Entraineur entraineur);

    void edit(Entraineur entraineur);

    void remove(Entraineur entraineur);

    Entraineur find(Object id);

    List<Entraineur> findAll();

    List<Entraineur> findRange(int[] range);

    int count();

    void creerEntraineur(String nom, String prenom, String login, String mdp, List<HistoriqueEEquipe>  histoEE);

    Entraineur authen(String log, String mdp);

    Entraineur rechercheEntraineur(String n, String p);
    
}
