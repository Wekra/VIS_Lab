package de.hska.vis.webshop.action;

import com.opensymphony.xwork2.ActionSupport;
import de.hska.vis.webshop.helper.HibernateUtil;
import de.hska.vis.webshop.model.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Created by Marcel on 10.12.2015.
 */
public class Delete_Category extends ActionSupport {

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private long id;

    public Category getCategoryBean() {
        return categoryBean;
    }

    public void setCategoryBean(Category categoryBean) {
        this.categoryBean = categoryBean;
    }

    private Category categoryBean;

    public String execute()
    {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = null;
        Transaction transaction = null;

        try {
            session = sf.getCurrentSession();
            transaction = session.beginTransaction();
            categoryBean = (Category) session.get(Category.class,this.id);
            session.delete(categoryBean);
            transaction.commit();

            return SUCCESS;

        } catch (Exception e){
            System.out.println(e.getMessage());
            return INPUT;
        }
    }
}
