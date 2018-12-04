/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

import java.io.Serializable;
import java.util.Date;
import java.util.Formatter;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author anastasia.salari
 */
@Entity
public class Match1 implements Serializable {

    
    @ManyToOne
        private Arbitre arbitre;

    /**
     * Get the value of arbitre
     *
     * @return the value of arbitre
     */
    public Arbitre getArbitre() {
        return arbitre;
    }

    /**
     * Set the value of arbitre
     *
     * @param arbitre new value of arbitre
     */
    public void setArbitre(Arbitre arbitre) {
        this.arbitre = arbitre;
    }

    
    @ManyToMany
        private List<Joueur> compoE2;

    /**
     * Get the value of compoE2
     *
     * @return the value of compoE2
     */
    public List<Joueur> getCompoE2() {
        return compoE2;
    }

    /**
     * Set the value of compoE2
     *
     * @param compoE2 new value of compoE2
     */
    public void setCompoE2(List<Joueur> compoE2) {
        this.compoE2 = compoE2;
    }

    
    @ManyToMany
        private List<Joueur> compoE1;

    /**
     * Get the value of compoE1
     *
     * @return the value of compoE1
     */
    public List<Joueur> getCompoE1() {
        return compoE1;
    }

    /**
     * Set the value of compoE1
     *
     * @param compoE1 new value of compoE1
     */
    public void setCompoE1(List<Joueur> compoE1) {
        this.compoE1 = compoE1;
    }

    
    @OneToMany(mappedBy = "match")
    private List<FauteComise> fautes;

    public List<FauteComise> getFautes() {
        return fautes;
    }

    public void setFautes(List<FauteComise> fautes) {
        this.fautes = fautes;
    }

    
    private int butsE2;

    /**
     * Get the value of butsE2
     *
     * @return the value of butsE2
     */
    public int getButsE2() {
        return butsE2;
    }

    /**
     * Set the value of butsE2
     *
     * @param butsE2 new value of butsE2
     */
    public void setButsE2(int butsE2) {
        this.butsE2 = butsE2;
    }

    
    private int butsE1;

    /**
     * Get the value of butsE1
     *
     * @return the value of butsE1
     */
    public int getButsE1() {
        return butsE1;
    }

    /**
     * Set the value of butsE1
     *
     * @param butsE1 new value of butsE1
     */
    public void setButsE1(int butsE1) {
        this.butsE1 = butsE1;
    }

          private String heureMinute;

    /**
     * Get the value of heureMinute
     *
     * @return the value of heureMinute
     */
    public String getHeureMinute() {
        return heureMinute;
    }

    /**
     * Set the value of heureMinute
     *
     * @param heureMinute new value of heureMinute
     */
    public void setHeureMinute(String heureMinute) {
        this.heureMinute = heureMinute;
    }


       @Temporal(javax.persistence.TemporalType.DATE)
       private Date date;

    /**
     * Get the value of date
     *
     * @return the value of date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Set the value of date
     *
     * @param date new value of date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    
    @ManyToOne
    private Equipe equipe1;

    /**
     * Get the value of equipe1
     *
     * @return the value of equipe1
     */
    public Equipe getEquipe1() {
        return equipe1;
    }

    /**
     * Set the value of equipe1
     *
     * @param equipe1 new value of equipe1
     */
    public void setEquipe1(Equipe equipe1) {
        this.equipe1 = equipe1;
    }

    @ManyToOne
        private Equipe equipe2;

    /**
     * Get the value of equipe2
     *
     * @return the value of equipe2
     */
    public Equipe getEquipe2() {
        return equipe2;
    }

    /**
     * Set the value of equipe2
     *
     * @param equipe2 new value of equipe2
     */
    public void setEquipe2(Equipe equipe2) {
        this.equipe2 = equipe2;
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
        if (!(object instanceof Match1)) {
            return false;
        }
        Match1 other = (Match1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.Match1[ id=" + id + " ]";
    }
    
}
