package de.hska.vis.webshop.action;

import com.opensymphony.xwork2.ActionSupport;
import de.hska.vis.webshop.helper.DatabaseQueries;
import de.hska.vis.webshop.model.Product;

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

    public String getCategoryLabel() {
        return categoryLabel;
    }

    public void setCategoryLabel(String categoryLabel) {
        this.categoryLabel = categoryLabel;
    }

    private String categoryLabel;

    public String execute()
    {
        productBean = database.getProductFromId(this.id);
        categoryLabel = database.getCategory_labelFromId(productBean.getCategory_id());
        if(productBean == null) return INPUT;

        return SUCCESS;
    }
}