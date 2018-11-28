/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author anastasia.salari
 */
@Entity
public class FauteComise implements Serializable {

    @ManyToOne
    private Joueur joueur;

    /**
     * Get the value of joueur
     *
     * @return the value of joueur
     */
    public Joueur getJoueur() {
        return joueur;
    }

    /**
     * Set the value of joueur
     *
     * @param joueur new value of joueur
     */
    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    
    @ManyToOne
    private Match1 match;

    /**
     * Get the value of match
     *
     * @return the value of match
     */
    public Match1 getMatch() {
        return match;
    }

    /**
     * Set the value of match
     *
     * @param match new value of match
     */
    public void setMatch(Match1 match) {
        this.match = match;
    }


    private Faute faute;

    /**
     * Get the value of faute
     *
     * @return the value of faute
     */
    public Faute getFaute() {
        return faute;
    }

    /**
     * Set the value of faute
     *
     * @param faute new value of faute
     */
    public void setFaute(Faute faute) {
        this.faute = faute;
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
        if (!(object instanceof FauteComise)) {
            return false;
        }
        FauteComise other = (FauteComise) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.FauteComise[ id=" + id + " ]";
    }
    
}
