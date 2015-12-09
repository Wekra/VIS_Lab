package de.hska.vis.webshop.action;

import com.opensymphony.xwork2.ActionSupport;
import de.hska.vis.webshop.helper.HibernateUtil;
import de.hska.vis.webshop.model.Product;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Marcel on 07.12.2015.
 */
public class GoTo_Admin_Main extends ActionSupport {

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    private List<Product> productList;

    public String execute() {

        productList = createProductList();
        return SUCCESS;
    }

    /**
     * creates a list with all products
     * @return null if no product exists or a list with all existing products
     */
    private java.util.List<Product> createProductList() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        String sql = "from Product";
        Query query = session.createQuery(sql);
        java.util.List<Product> list = query.list();
        if (list.size() > 0) {
            session.close();
            return list;
        }
        session.close();
        return null;
    }
}
