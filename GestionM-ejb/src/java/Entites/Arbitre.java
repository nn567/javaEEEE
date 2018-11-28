/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author anastasia.salari
 */
@Entity
public class Arbitre extends Utilisateur implements Serializable {

    @OneToMany(mappedBy = "arbitre")
    private List<Match1> match1s;

    @OneToMany(mappedBy = "arbitre")
    private List<Match1> matchs;

    public List<Match1> getMatchs() {
        return matchs;
    }

    public void setMatchs(List<Match1> matchs) {
        this.matchs = matchs;
    }

    
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Arbitre)) {
            return false;
        }
        Arbitre other = (Arbitre) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.Arbitre[ id=" + id + " ]";
    }
    
}
