package de.hska.vis.webshop.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Christian on 30.11.2015.
 */
public class ProCatPK implements Serializable {
    private long pId;
    private long cId;

    @Column(name = "P_ID")
    @Id
    public long getpId() {
        return pId;
    }

    public void setpId(long pId) {
        this.pId = pId;
    }

    @Column(name = "C_ID")
    @Id
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

        ProCatPK proCatPK = (ProCatPK) o;

        if (pId != proCatPK.pId) return false;
        if (cId != proCatPK.cId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (pId ^ (pId >>> 32));
        result = 31 * result + (int) (cId ^ (cId >>> 32));
        return result;
    }
}
