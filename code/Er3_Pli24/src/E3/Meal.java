/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package E3;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "MEAL")
@NamedQueries({
    @NamedQuery(name = "Meal.findAll", query = "SELECT m FROM Meal m ORDER BY m.views DESC"),
    @NamedQuery(name = "Meal.findByMealId", query = "SELECT m FROM Meal m WHERE m.mealId = :mealId"),
    @NamedQuery(name = "Meal.findByStrmeal", query = "SELECT m FROM Meal m WHERE m.strmeal = :strmeal"),
    @NamedQuery(name = "Meal.findByStrarea", query = "SELECT m FROM Meal m WHERE m.strarea = :strarea"),
    @NamedQuery(name = "Meal.findByCategory", query = "SELECT m FROM Meal m WHERE m.category = :category"),
    @NamedQuery(name = "Meal.findByViews", query = "SELECT m FROM Meal m WHERE m.views = :views")})
public class Meal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MEAL_ID")
    private Integer mealId;
    @Basic(optional = false)
    @Column(name = "STRMEAL")
    private String strmeal;
    @Column(name = "STRAREA")
    private String strarea;
    @Lob
    @Column(name = "STRINSTUCTIONS")
    private String strinstuctions;
    @Basic(optional = false)
    @Column(name = "CATEGORY")
    private int category;
    @Column(name = "VIEWS")
    private Integer views;

    public Meal() {
    }

    public Meal(Integer mealId) {
        this.mealId = mealId;
    }

    public Meal(Integer mealId, String strmeal, int category) {
        this.mealId = mealId;
        this.strmeal = strmeal;
        this.category = category;
    }

    public Integer getMealId() {
        return mealId;
    }

    public void setMealId(Integer mealId) {
        this.mealId = mealId;
    }

    public String getStrmeal() {
        return strmeal;
    }

    public void setStrmeal(String strmeal) {
        this.strmeal = strmeal;
    }

    public String getStrarea() {
        return strarea;
    }

    public void setStrarea(String strarea) {
        this.strarea = strarea;
    }

    public String getStrinstuctions() {
        return strinstuctions;
    }

    public void setStrinstuctions(String strinstuctions) {
        this.strinstuctions = strinstuctions;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mealId != null ? mealId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Meal)) {
            return false;
        }
        Meal other = (Meal) object;
        if ((this.mealId == null && other.mealId != null) || (this.mealId != null && !this.mealId.equals(other.mealId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ergasia3_2022_23.Meal[ mealId=" + mealId + " ]";
    }
    
}
