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
public class Entraineur extends Utilisateur implements Serializable {

    @OneToMany(mappedBy = "entraineur")
    private List<HistoriqueEEquipe> historiqueEEquipes;

    public List<HistoriqueEEquipe> getHistoriqueEEquipes() {
        return historiqueEEquipes;
    }

    public void setHistoriqueEEquipes(List<HistoriqueEEquipe> historiqueEEquipes) {
        this.historiqueEEquipes = historiqueEEquipes;
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
        if (!(object instanceof Entraineur)) {
            return false;
        }
        Entraineur other = (Entraineur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.Entraineur[ id=" + id + " ]";
    }
    
}
