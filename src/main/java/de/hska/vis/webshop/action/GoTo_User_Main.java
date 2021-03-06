package de.hska.vis.webshop.action;

import com.opensymphony.xwork2.ActionSupport;
import de.hska.vis.webshop.helper.DatabaseQueries;
import de.hska.vis.webshop.model.Product;

import java.util.List;

/**
 * Created by Christian on 09.12.2015.
 * This class is used as action to redirect to the main page of the user view.
 */
public class GoTo_User_Main extends ActionSupport {

    private final DatabaseQueries database;

    public GoTo_User_Main(){
        super();
        database = new DatabaseQueries();
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    private List<Product> productList;

    public String execute() {

        productList = database.createProductList();
        return SUCCESS;
    }
}