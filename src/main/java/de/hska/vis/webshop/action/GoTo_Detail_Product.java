package de.hska.vis.webshop.action;

import com.mysql.fabric.xmlrpc.base.Data;
import com.opensymphony.xwork2.ActionSupport;
import de.hska.vis.webshop.helper.DatabaseQueries;
import de.hska.vis.webshop.helper.HibernateUtil;
import de.hska.vis.webshop.model.Product;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Created by Marcel on 07.12.2015.
 * This class is used as action to redirect to the detail page of a product.
 */

public class GoTo_Detail_Product extends ActionSupport {

    private final DatabaseQueries database;

    public GoTo_Detail_Product(){
        super();
        database = new DatabaseQueries();
    }

    public Product getProductBean() {
        return productBean;
    }

    public void setProductBean(Product productBean) {
        this.productBean = productBean;
    }

    private Product productBean;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private long id;

    public String execute()
    {
        productBean = database.getProductFromId(this.id);
        if(productBean == null) return INPUT;

        return SUCCESS;
    }
}
