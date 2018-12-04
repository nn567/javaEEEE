package Entites;

import Entites.Entraineur;
import Entites.Equipe;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-04T08:28:51")
@StaticMetamodel(HistoriqueEEquipe.class)
public class HistoriqueEEquipe_ { 

    public static volatile SingularAttribute<HistoriqueEEquipe, Entraineur> entraineur;
    public static volatile SingularAttribute<HistoriqueEEquipe, Date> dateDebut;
    public static volatile SingularAttribute<HistoriqueEEquipe, Date> dateFin;
    public static volatile SingularAttribute<HistoriqueEEquipe, Long> id;
    public static volatile SingularAttribute<HistoriqueEEquipe, Equipe> equipe;

}