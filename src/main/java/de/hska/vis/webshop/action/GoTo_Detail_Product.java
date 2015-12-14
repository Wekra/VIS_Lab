package de.hska.vis.webshop.action;

import com.opensymphony.xwork2.ActionSupport;
import de.hska.vis.webshop.helper.HibernateUtil;
import de.hska.vis.webshop.model.Category;
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

    public String getCategoryLabel() {
        return categoryLabel;
    }

    public void setCategoryLabel(String categoryLabel) {
        this.categoryLabel = categoryLabel;
    }

    private String categoryLabel;

    public String execute()
    {
        productBean = getProductFromId(this.id);
        categoryLabel = getCategory_labelFromId(productBean.getCategory_id());
        if(productBean == null) return INPUT;

        return SUCCESS;
    }

    /**
     * Gets the category_label with category_id
     * @param category_id long
     * @return String category_label
     */
    private String getCategory_labelFromId(long category_id)
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Category category =(Category)session.get(Category.class, category_id);

        session.close();
        return category.getLabel();
    }

    /**
     * Gets the Product with product_id
     * @param nid long product_id
     * @return Product
     */
    private Product getProductFromId(long nid) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Product product=(Product)session.get(Product.class, nid);
        session.close();

        return product;
    }

}
