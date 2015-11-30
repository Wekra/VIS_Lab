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
    private long product_id;
    private long user_id;

    @Id
    @Column(name="U_ID")
    @JoinColumn(name="U_ID")
    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    @Id
    @Column(name="P_ID")
    @JoinColumn(name="P_ID")
    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
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
