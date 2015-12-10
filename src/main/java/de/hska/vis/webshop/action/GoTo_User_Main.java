package de.hska.vis.webshop.action;

import com.opensymphony.xwork2.ActionSupport;
import de.hska.vis.webshop.helper.DatabaseQueries;
import de.hska.vis.webshop.helper.HibernateUtil;
import de.hska.vis.webshop.model.Product;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Christian on 09.12.2015.
 */
public class GoTo_User_Main extends ActionSupport {

    private DatabaseQueries database;

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