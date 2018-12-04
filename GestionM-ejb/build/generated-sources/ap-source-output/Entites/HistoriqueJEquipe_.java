package Entites;

import Entites.Equipe;
import Entites.Joueur;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-04T09:36:55")
@StaticMetamodel(HistoriqueJEquipe.class)
public class HistoriqueJEquipe_ { 

    public static volatile SingularAttribute<HistoriqueJEquipe, Date> dateDebut;
    public static volatile SingularAttribute<HistoriqueJEquipe, Joueur> joueur;
    public static volatile SingularAttribute<HistoriqueJEquipe, Date> dateFin;
    public static volatile SingularAttribute<HistoriqueJEquipe, Long> id;
    public static volatile SingularAttribute<HistoriqueJEquipe, Equipe> equipe;

}