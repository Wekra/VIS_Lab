package de.hska.vis.webshop.action;

import com.opensymphony.xwork2.ActionSupport;
import de.hska.vis.webshop.helper.DatabaseQueries;
import de.hska.vis.webshop.model.Category;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Marcel on 07.12.2015.
 * This class is used as action to create a new category in the webshop.
 */
public class Add_Category extends ActionSupport {

    private final DatabaseQueries database;

    public Add_Category(){
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

    @Override
    public String execute() {

        //returns input if the category exists already
        Category category;
        category = database.getCategoryByLabel(categoryBean.getLabel());
        if (!(category == null)) return INPUT;

        boolean categoryWasSaved = database.saveCategoryToDatabase(categoryBean);

        if(categoryWasSaved){
            return SUCCESS;
        } else {
            return INPUT;
        }
    }

    /**
     * Gives the category with the choosen label
     * @param label String categoryname
     * @return null if category doesn't exist or the category
     */
    private Category getCategoryByLabel(String label)
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        String sql = "from Category as u where u.label=:label";
        Query query = session.createQuery(sql);
        query.setParameter("label", label);
        List<Category> list = query.list();
        if (list.size() > 0 ){
            session.close();
            return list.get(0);
        }
        session.close();
        return null;
    }
}
