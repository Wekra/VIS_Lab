package de.hska.vis.webshop.action;

import com.opensymphony.xwork2.ActionSupport;
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

        if(!allowedToDeleteCategory(categoryBean.getCategory_id()))
        {
            return INPUT;
        }
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


    private Boolean allowedToDeleteCategory(long id)
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();

        String sql = "from Product as u where u.category_id=:id";
        Query query = session.createQuery(sql);
        query.setParameter("id", id);
        List<Product> list = query.list();
        if (list.size() > 0 ){
            session.close();
            return false;
        }
        session.close();
        return true;
    }
}
