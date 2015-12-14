package de.hska.vis.webshop.action;

import com.opensymphony.xwork2.ActionSupport;
import de.hska.vis.webshop.helper.DatabaseQueries;
import de.hska.vis.webshop.model.Product;

/**
 * Created by Marcel on 10.12.2015.
 * This class is used as action to update a product.
 */
public class Edit_Product extends ActionSupport {

    private final DatabaseQueries database;

    public Edit_Product(){
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

    public String getCategoryLabel() {
        return categoryLabel;
    }

    public void setCategoryLabel(String categoryLabel) {
        this.categoryLabel = categoryLabel;
    }

    private String categoryLabel;

    public String execute()
    {
        Product product = database.getProductByLabel(productBean.getLabel());



        if (product != null) {
            if(product.getProduct_id() != productBean.getProduct_id()) {
                return INPUT;
            }
        }

        productBean.setCategory_id(database.getCategory_idFromLabel(categoryLabel));

        if(database.updateProduct(productBean)){
            return SUCCESS;
        }else{
            return INPUT;
        }
    }


}