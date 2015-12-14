package de.hska.vis.webshop.action;

import com.opensymphony.xwork2.ActionSupport;
import de.hska.vis.webshop.helper.DatabaseQueries;
import de.hska.vis.webshop.helper.HibernateUtil;
import de.hska.vis.webshop.model.Category;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Marcel on 10.12.2015.
 * This class is used as action to redirect to the edit-category page.
 */
public class GoTo_Edit_Category extends ActionSupport {

    private final DatabaseQueries database;

    public GoTo_Edit_Category(){
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

    public Category getOldCategoryBean() {
        return oldCategoryBean;
    }

    public void setOldCategoryBean(Category oldCategoryBean) {
        this.oldCategoryBean = oldCategoryBean;
    }

    private Category oldCategoryBean;


    public String execute()
    {
        oldCategoryBean = database.getOldCategory(this.specialId);

        if(oldCategoryBean != null){
            return SUCCESS;

        } else {
            return INPUT;
        }
    }
}