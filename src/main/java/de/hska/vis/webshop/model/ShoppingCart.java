package de.hska.vis.webshop.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Christian on 30.11.2015.
 */
@Entity
@Table(name = "shopping_cart", schema = "vislab")
public class ShoppingCart implements Serializable {
    private int count;
    private long pId;
    private long uId;

    @Id
    @Column(name = "U_ID", nullable = false)
    public long getuId() {
        return uId;
    }

    public void setuId(long uId) {
        this.uId = uId;
    }

    @Column(name = "P_ID", nullable = false)
    @Id
    public long getpId() {
        return pId;
    }

    public void setpId(long pId) {
        this.pId = pId;
    }

    @Basic
    @Column(name = "COUNT")
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShoppingCart that = (ShoppingCart) o;

        if (count != that.count) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return count;
    }
}
