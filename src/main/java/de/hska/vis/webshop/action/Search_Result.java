package de.hska.vis.webshop.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.validators.LongRangeFieldValidator;
import de.hska.vis.webshop.helper.DatabaseQueries;
import de.hska.vis.webshop.helper.HibernateUtil;
import de.hska.vis.webshop.model.Product;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Marcel on 08.12.2015.
 * This class is used as action to display the results of a performed search.
 */
public class Search_Result extends ActionSupport {

    private final DatabaseQueries database;

    public Search_Result(){
        super();
        database = new DatabaseQueries();
    }

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

        String sql =
                "from Product p " +
                        /*", Category c " +*/
                        "where (p.label like :text or p.description like :text " +
                /*"or(c.label like :text and (p.category_id = c.category_id))" +*/
                ") and p.price between :min and :max";
        Query query = session.createQuery(sql);
        query.setParameter("text", "%" + text +"%");
        query.setParameter("min",min);
        query.setParameter("max", max);
        java.util.List<Product> list = query.list();
        /*
        java.util.List<Product> list = null;

        for(int i = 0; list2.size() > i; i++)
        {
            list.add((Product)session.get(Product.class, list2.get(i)));
        }
        */
        if (list.size() > 0) {
            session.close();

            return list;
        }
        session.close();
        return null;
    }
}
