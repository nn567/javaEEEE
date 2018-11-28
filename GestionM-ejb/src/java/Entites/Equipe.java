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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author anastasia.salari
 */
@Entity
public class Equipe implements Serializable {

    @OneToMany(mappedBy = "equipe2")
    private List<Match1> matchs1;

    @OneToMany(mappedBy = "equipe1")
    private List<Match1> matchs;

   
   

    @OneToMany(mappedBy = "equipe")
    private List<HistoriqueEEquipe> historiqueEEquipes;

    public List<HistoriqueEEquipe> getHistoriqueEEquipes() {
        return historiqueEEquipes;
    }

    public void setHistoriqueEEquipes(List<HistoriqueEEquipe> historiqueEEquipes) {
        this.historiqueEEquipes = historiqueEEquipes;
    }
    
    

    @OneToMany(mappedBy = "equipe")
    private List<HistoriqueJEquipe> historiqueJE;

    public List<HistoriqueJEquipe> getHistoriqueJE() {
        return historiqueJE;
    }

    public void setHistoriqueJE(List<HistoriqueJEquipe> historiqueJE) {
        this.historiqueJE = historiqueJE;
    }
  
    
    private int points;

    /**
     * Get the value of points
     *
     * @return the value of points
     */
    public int getPoints() {
        return points;
    }

    /**
     * Set the value of points
     *
     * @param points new value of points
     */
    public void setPoints(int points) {
        this.points = points;
    }

    private String nomE;

    /**
     * Get the value of nomE
     *
     * @return the value of nomE
     */
    public String getNomE() {
        return nomE;
    }

    /**
     * Set the value of nomE
     *
     * @param nomE new value of nomE
     */
    public void setNomE(String nomE) {
        this.nomE = nomE;
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
        if (!(object instanceof Equipe)) {
            return false;
        }
        Equipe other = (Equipe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.Equipe[ id=" + id + " ]";
    }
    
}
