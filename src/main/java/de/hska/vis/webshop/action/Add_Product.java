package de.hska.vis.webshop.action;

import com.opensymphony.xwork2.ActionSupport;
import de.hska.vis.webshop.helper.DatabaseQueries;
import de.hska.vis.webshop.helper.HibernateUtil;
import de.hska.vis.webshop.model.Category;
import de.hska.vis.webshop.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Query;

import java.util.List;
/**
 * Created by Marcel on 30.11.2015.
 * This class is used as action to add a product to the database.
 */
public class Add_Product extends ActionSupport {

    private final DatabaseQueries database;

    public Add_Product(){
        super();
        database = new DatabaseQueries();
    }

    public Product getProductBean(){return this.productBean;}

    public void setProductBean(Product productBean) {this.productBean = productBean;}

    private Product productBean;
/*
    public String[] getCategoryLabelList() {
        return categoryLabelList;
    }

    public void setCategoryLabelList(String[] categoryLabelList) {
        this.categoryLabelList = categoryLabelList;
    }

    private String[] categoryLabelList;
*/
    public String getCategory_label() {
        return category_label;
    }

    public void setCategory_label(String category_label) {
        this.category_label = category_label;
    }

    private String category_label;

    public String execute()
    {
        //returns input if the category exists already
        Product product;
        product = database.getProductByLabel(productBean.getLabel());
        if (!(product == null)){
            return INPUT;
        }
        //Set Product.category_id to the Category_id
        productBean.setCategory_id(database.getCategory_idFromLabel(category_label));

        boolean wasProductSaved = database.saveProductToDatabase(productBean);

        if(wasProductSaved){
            return SUCCESS;
        } else {
            return INPUT;
        }
    }

  /*  public void validate(){
        Product product = null;
        product = getProductByLabel(productBean.getLabel());
        if(product != null){
            addFieldError("productBean.label", "Dieses Produkt existiert bereits.");
            helperList = createCategoryList();

            //create String Array with the labels of the categories
            categoryLabelList = new String[helperList.size()];
            for(int i = 0; helperList.size() > i; i++) {
                categoryLabelList[i] = helperList.get(i).getLabel();
            }
        }

    }*/
}
