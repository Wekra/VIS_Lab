package de.hska.vis.webshop.action;

import com.opensymphony.xwork2.ActionSupport;
import de.hska.vis.webshop.model.Product;

/**
 * Created by Marcel on 07.12.2015.
 */

public class GoTo_Detail_Product extends ActionSupport {

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    private Product product;
}
