package de.hska.vis.webshop.action;

import com.opensymphony.xwork2.ActionSupport;
import de.hska.vis.webshop.helper.DatabaseQueries;
import de.hska.vis.webshop.model.Product;

/**
 * Created by Marcel on 09.12.2015.
 * This class is used as action to delete a product.
 */
public class Delete_Product extends ActionSupport {

    private final DatabaseQueries database;

    public Delete_Product(){
        super();
        database = new DatabaseQueries();
    }

    public long getSpecialId() {
        return specialId;
    }

    public void setSpecialId(long specialId) {
        this.specialId = specialId;
    }

    private long specialId;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    private Product product;

    public String execute()
    {

        if(database.deleteProduct(this.specialId)){
            return SUCCESS;
        }else{
            return INPUT;
        }
    }
}
