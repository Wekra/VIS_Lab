package de.hska.vis.webshop.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Christian on 30.11.2015.
 * This class represents the category-table of the webshop database.
 */
@Entity
public class Category {

    private long category_id;
    private String label;
    private String description;

    @Id
    @Column(name = "C_ID")
    public long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(long cId) {
        this.category_id = cId;
    }

    @Basic
    @Column(name = "LABEL")
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Basic
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (category_id != category.category_id) return false;
        if (label != null ? !label.equals(category.label) : category.label != null) return false;
        if (description != null ? !description.equals(category.description) : category.description != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (category_id ^ (category_id >>> 32));
        result = 31 * result + (label != null ? label.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
