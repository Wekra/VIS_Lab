package de.hska.vis.webshop.model;

import com.mysql.jdbc.Blob;

import javax.persistence.*;

/**
 * Created by Christian on 30.11.2015.
 */
@Entity
public class Product {
    private long product_id;
    private String label;
    private String description;
    private double price;
    private int stock;
    private long category_id;


    @Column(name = "C_ID")
    @JoinColumn(name = "C_ID")
    public long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(long category_id) {
        this.category_id = category_id;
    }

    @Id
    @Column(name = "P_ID")
    public long getpProduct_id() {
        return product_id;
    }

    public void setpProduct_id(long pId) {
        this.product_id = pId;
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

    @Basic
    @Column(name = "PRICE")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "STOCK")
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (product_id != product.product_id) return false;
        if (Double.compare(product.price, price) != 0) return false;
        if (stock != product.stock) return false;
        if (label != null ? !label.equals(product.label) : product.label != null) return false;
        if (description != null ? !description.equals(product.description) : product.description != null) return false;
        //if (!Arrays.equals(image, product.image)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (product_id ^ (product_id >>> 32));
        result = 31 * result + (label != null ? label.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        //result = 31 * result + Arrays.hashCode(image);
        result = 31 * result + stock;
        return result;
    }
}
