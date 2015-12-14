package de.hska.vis.webshop.action;

import com.opensymphony.xwork2.ActionSupport;
import de.hska.vis.webshop.helper.DatabaseQueries;
import de.hska.vis.webshop.helper.HibernateUtil;
import de.hska.vis.webshop.model.Category;
import de.hska.vis.webshop.model.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Marcel on 10.12.2015.
 * This class is used as action to go to the edit-product page.
 */
public class GoTo_Edit_Product extends ActionSupport {

    private final DatabaseQueries database;

    public GoTo_Edit_Product(){
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

    public Product getOldProductBean() {
        return oldProductBean;
    }

    public void setOldProductBean(Product oldProductBean) {
        this.oldProductBean = oldProductBean;
    }

    private Product oldProductBean;

    public String[] getCategoryLabelList() {
        return categoryLabelList;
    }

    public void setCategoryLabelList(String[] categoryLabelList) {
        this.categoryLabelList = categoryLabelList;
    }

    private String[] categoryLabelList;

    public String getOldCategoryLabel() {
        return oldCategoryLabel;
    }

    public void setOldCategoryLabel(String oldCategoryLabel) {
        this.oldCategoryLabel = oldCategoryLabel;
    }

    private String oldCategoryLabel;

    public String execute() {
        List<Category> helperList;

        helperList = database.createCategoryList();
        if (helperList == null) {
            return INPUT;
        }

        //create String Array with the labels of the categorys
        categoryLabelList = new String[helperList.size()];
        for (int i = 0; helperList.size() > i; i++) {
            categoryLabelList[i] = helperList.get(i).getLabel();
        }

        oldProductBean = database.getOldProduct(this.specialId);

        if(oldProductBean == null){
            return INPUT;
        }

        oldCategoryLabel = database.getCategory_labelFromId(oldProductBean.getCategory_id());

        return SUCCESS;
    }
}