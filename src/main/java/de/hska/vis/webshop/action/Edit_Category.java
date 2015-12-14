package de.hska.vis.webshop.action;

import com.opensymphony.xwork2.ActionSupport;
import de.hska.vis.webshop.helper.DatabaseQueries;
import de.hska.vis.webshop.helper.HibernateUtil;
import de.hska.vis.webshop.model.Category;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * Created by Marcel on 10.12.2015.
 * This class is used as action to edit a category.
 */
public class Edit_Category extends ActionSupport {

    private final DatabaseQueries database;

    public Edit_Category(){
        super();
        database = new DatabaseQueries();
    }

    public Category getCategoryBean() {
        return categoryBean;
    }

    public void setCategoryBean(Category categoryBean) {
        this.categoryBean = categoryBean;
    }

    private Category categoryBean;

    public String execute()
    {
        if(database.doesCategoryExist(categoryBean.getLabel()))
        {
            return INPUT;
        }

        if(database.updateCategory(categoryBean)){
            return SUCCESS;
        }else {
            return INPUT;
        }
    }
}