package de.hska.vis.webshop.action;

import com.opensymphony.xwork2.ActionSupport;
import de.hska.vis.webshop.helper.HibernateUtil;
import de.hska.vis.webshop.model.Product;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Created by Marcel on 07.12.2015.
 */

public class GoTo_Detail_Product extends ActionSupport {

    public Product getProductBean() {
        return productBean;
    }

    public void setProductBean(Product productBean) {
        this.productBean = productBean;
    }

    private Product productBean;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private long id;

    public String execute()
    {
        productBean = getProductFromId(this.id);
        if(productBean == null) return INPUT;

        return SUCCESS;
    }

    private Product getProductFromId(long nid) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        String sql = "from Product as u where u.product_id =:na";
        Query query = session.createQuery(sql);
        query.setParameter("na", nid);
        java.util.List<Product> list = query.list();
        if (list.size() > 0) {
            session.close();
            return list.get(0);
        }
        session.close();
        return null;
    }

}
