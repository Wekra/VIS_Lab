package de.hska.vis.webshop.action;

import com.opensymphony.xwork2.ActionSupport;
import de.hska.vis.webshop.helper.HibernateUtil;
import de.hska.vis.webshop.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Created by Marcel on 10.12.2015.
 */
public class Edit_Product extends ActionSupport {

    public Product getProductBean() {
        return productBean;
    }

    public void setProductBean(Product productBean) {
        this.productBean = productBean;
    }

    private Product productBean;

    public String execute()
    {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = null;
        Transaction transaction = null;

        try {
            session = sf.getCurrentSession();
            transaction = session.beginTransaction();
            session.update(productBean);
            transaction.commit();

            return SUCCESS;

        } catch (Exception e){
            System.out.println(e.getMessage());
            return INPUT;
        }
    }
}
