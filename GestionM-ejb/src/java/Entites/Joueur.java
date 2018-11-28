/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author anastasia.salari
 */
@Entity
public class Joueur extends Personne implements Serializable {

    @ManyToMany(mappedBy = "compoE2")
    private List<Match1> match1s1;

    @ManyToMany(mappedBy = "compoE1")
    private List<Match1> match1s;

    
  
    private Date dateInterdiction;

    /**
     * Get the value of dateInterdiction
     *
     * @return the value of dateInterdiction
     */
    
    public Date getDateInterdiction() {
        return dateInterdiction;
    }

    /**
     * Set the value of dateInterdiction
     *
     * @param dateInterdiction new value of dateInterdiction
     */
    public void setDateInterdiction(Date dateInterdiction) {
        this.dateInterdiction = dateInterdiction;
    }

    
    @OneToMany(mappedBy = "joueur")
    private List<HistoriqueJEquipe> historiqueJEquipes;

    public List<HistoriqueJEquipe> getHistoriqueJEquipes() {
        return historiqueJEquipes;
    }

    public void setHistoriqueJEquipes(List<HistoriqueJEquipe> historiqueJEquipes) {
        this.historiqueJEquipes = historiqueJEquipes;
    }

    
    @OneToMany(mappedBy = "joueur")
    private List<FauteComise> fauteComises;

    public List<FauteComise> getFauteComises() {
        return fauteComises;
    }

    public void setFauteComises(List<FauteComise> fauteComises) {
        this.fauteComises = fauteComises;
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
        if (!(object instanceof Joueur)) {
            return false;
        }
        Joueur other = (Joueur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.Joueur[ id=" + id + " ]";
    }
    
}
