package de.hska.vis.webshop.action;

import com.opensymphony.xwork2.ActionSupport;
import de.hska.vis.webshop.helper.HibernateUtil;
import de.hska.vis.webshop.model.Product;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Marcel on 08.12.2015.
 */
public class Search_Result extends ActionSupport {

    private String searchText;

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    private double minPrice;

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    private double maxPrice;

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    private List<Product> productList;

    public String execute()
    {

        if(maxPrice <= 0) maxPrice = 1000000;
        productList = productSearch(searchText, minPrice, maxPrice);
        return SUCCESS;
    }

    private java.util.List<Product> productSearch(String text, double min, double max) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();

        String sql = "from Product as u, Category as c where (u.label like :text or u.description like :text " +
                /*"or(c.label like :text and u.category_id = c.category_id)" +*/
                ") and u.price between :min and :max";
        Query query = session.createQuery(sql);
        query.setParameter("text", "%" + text +"%");
        query.setParameter("min",min);
        query.setParameter("max", max);
        java.util.List<Product> list = query.list();

        if (list.size() > 0) {
            session.close();

            return list;
        }
        session.close();
        return null;
    }
}
