package de.hska.vis.webshop.action;

import com.opensymphony.xwork2.ActionSupport;
import de.hska.vis.webshop.helper.DatabaseQueries;
import de.hska.vis.webshop.model.Category;
import de.hska.vis.webshop.model.Product;

import java.util.List;

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

    public String[] getCategoryLabelList() {
        return categoryLabelList;
    }

    public void setCategoryLabelList(String[] categoryLabelList) {
        this.categoryLabelList = categoryLabelList;
    }

    private String[] categoryLabelList;

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
                return "productExists";
            }
        }

        productBean.setCategory_id(database.getCategory_idFromLabel(categoryLabel));

        if(database.updateProduct(productBean)){
            return SUCCESS;
        }else{
            addActionError("Änderungen konnten nicht in der Datenbank gespeichert werden.");
            return INPUT;
        }
    }

    @Override
    public void validate(){
        if(productBean.getLabel().isEmpty() || productBean.getLabel().trim().isEmpty()){
            addFieldError("productBean.label", "Dieses Feld darf nicht leer sein.");
        }

        if(productBean.getDescription().isEmpty() || productBean.getDescription().trim().isEmpty()){
            addFieldError("productBean.description", "Dieses Feld darf nicht leer sein.");

        }

        List<Category> helperList;

        helperList = database.createCategoryList();

        categoryLabelList = new String[helperList.size()];
        for (int i = 0; helperList.size() > i; i++) {
            categoryLabelList[i] = helperList.get(i).getLabel();
        }
    }
}