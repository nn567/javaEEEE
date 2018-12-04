package Entites;

import Entites.FauteComise;
import Entites.HistoriqueJEquipe;
import Entites.Match1;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-03T22:14:26")
@StaticMetamodel(Joueur.class)
public class Joueur_ extends Personne_ {

    public static volatile ListAttribute<Joueur, HistoriqueJEquipe> historiqueJEquipes;
    public static volatile ListAttribute<Joueur, FauteComise> fauteComises;
    public static volatile ListAttribute<Joueur, Match1> match1s;
    public static volatile SingularAttribute<Joueur, Date> dateInterdiction;
    public static volatile ListAttribute<Joueur, Match1> match1s1;

}