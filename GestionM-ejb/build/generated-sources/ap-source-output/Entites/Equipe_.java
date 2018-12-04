package Entites;

import Entites.HistoriqueEEquipe;
import Entites.HistoriqueJEquipe;
import Entites.Match1;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-04T09:36:55")
@StaticMetamodel(Equipe.class)
public class Equipe_ { 

    public static volatile ListAttribute<Equipe, Match1> matchs;
    public static volatile ListAttribute<Equipe, HistoriqueJEquipe> historiqueJE;
    public static volatile SingularAttribute<Equipe, String> nomE;
    public static volatile SingularAttribute<Equipe, Long> id;
    public static volatile ListAttribute<Equipe, Match1> matchs1;
    public static volatile ListAttribute<Equipe, HistoriqueEEquipe> historiqueEEquipes;
    public static volatile SingularAttribute<Equipe, Integer> points;

}