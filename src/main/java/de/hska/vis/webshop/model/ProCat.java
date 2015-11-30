package de.hska.vis.webshop.model;

import javax.persistence.*;

/**
 * Created by Christian on 30.11.2015.
 */
@Entity
@Table(name = "pro_cat", schema = "vislab", catalog = "")
@IdClass(ProCatPK.class)
public class ProCat {
    private long pId;
    private long cId;

    @Id
    @Column(name = "P_ID")
    public long getpId() {
        return pId;
    }

    public void setpId(long pId) {
        this.pId = pId;
    }

    @Id
    @Column(name = "C_ID")
    public long getcId() {
        return cId;
    }

    public void setcId(long cId) {
        this.cId = cId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProCat proCat = (ProCat) o;

        if (pId != proCat.pId) return false;
        if (cId != proCat.cId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (pId ^ (pId >>> 32));
        result = 31 * result + (int) (cId ^ (cId >>> 32));
        return result;
    }
}
