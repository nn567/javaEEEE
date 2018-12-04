package Entites;

import Entites.Arbitre;
import Entites.Equipe;
import Entites.FauteComise;
import Entites.Joueur;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-04T09:36:55")
@StaticMetamodel(Match1.class)
public class Match1_ { 

    public static volatile SingularAttribute<Match1, Date> date;
    public static volatile SingularAttribute<Match1, Arbitre> arbitre;
    public static volatile ListAttribute<Match1, FauteComise> fautes;
    public static volatile SingularAttribute<Match1, Equipe> equipe2;
    public static volatile SingularAttribute<Match1, Equipe> equipe1;
    public static volatile ListAttribute<Match1, Joueur> compoE2;
    public static volatile ListAttribute<Match1, Joueur> compoE1;
    public static volatile SingularAttribute<Match1, String> heureMinute;
    public static volatile SingularAttribute<Match1, Long> id;
    public static volatile SingularAttribute<Match1, Integer> butsE1;
    public static volatile SingularAttribute<Match1, Integer> butsE2;

}