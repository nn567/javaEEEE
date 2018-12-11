/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import Facade.Match1FacadeLocal;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Meiji
 */
@Stateless
public class gestionPublic implements gestionPublicLocal {

    @EJB
    private Match1FacadeLocal match1Facade;

    @Override
    public List afficherMatchDate(Date date) {
         return match1Facade.afficherMatchDate(date);
    }

    @Override
    public List afficherMatchIntervalleDate(Date datedebut, Date datefin) {
        return match1Facade.afficherMatchIntervalleDate(datedebut, datefin);
    }

    
}
