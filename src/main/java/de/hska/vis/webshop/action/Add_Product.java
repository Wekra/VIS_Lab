package de.hska.vis.webshop.action;

import com.opensymphony.xwork2.ActionSupport;
import de.hska.vis.webshop.helper.HibernateUtil;
import de.hska.vis.webshop.model.Category;
import de.hska.vis.webshop.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Query;

import java.util.List;
/**
 * Created by Marcel on 30.11.2015.
 */
public class Add_Product extends ActionSupport {

    private List<Category> helperList;

    public Product getProductBean(){return this.productBean;}

    public void setProductBean(Product productBean) {this.productBean = productBean;}

    private Product productBean;

    public String[] getCategoryLabelList() {
        return categoryLabelList;
    }

    public void setCategoryLabelList(String[] categoryLabelList) {
        this.categoryLabelList = categoryLabelList;
    }

    private String[] categoryLabelList;

    public String execute()
    {
        //returns input if the category exists already
        Product product = null;
        product = getProductByLabel(productBean.getLabel());
        if (!(product == null)){
            helperList = createCategoryList();

            //create String Array with the labels of the categorys
            categoryLabelList = new String[helperList.size()];
            for(int i = 0; helperList.size() > i; i++)
            {
                categoryLabelList[i] = helperList.get(i).getLabel();
            }
            return INPUT;
        }

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = null;
        Transaction transaction = null;

        //saves the category in database
        try {
            session = sf.getCurrentSession();
            transaction = session.beginTransaction();
            session.save(productBean);
            transaction.commit();

            return SUCCESS;

        } catch (Exception e){
            System.out.println(e.getMessage());
            return INPUT;
        }
    }

    /**
     * Gives the product with the choosen label
     * @param label String productname
     * @return null if product doesn't exist or the product
     */
    private Product getProductByLabel(String label)
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        String sql = "from Product as u where u.label=:label";
        Query query = session.createQuery(sql);
        query.setParameter("label", label);
        List<Product> list = query.list();
        if (list.size() > 0 ){
            session.close();
            return list.get(0);
        }
        session.close();
        return null;
    }

    /**
     * creates a list with all categorys in it
     * @return null if the list is empty or the list
     */
    private List<Category> createCategoryList()
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        String sql = "from Category ";
        Query query = session.createQuery(sql);
        List<Category> list = query.list();
        if (list.size() > 0) {
            session.close();
            return list;
        }
        session.close();
        return null;
    }

  /*  public void validate(){
        Product product = null;
        product = getProductByLabel(productBean.getLabel());
        if(product != null){
            addFieldError("productBean.label", "Dieses Produkt existiert bereits.");
            helperList = createCategoryList();

            //create String Array with the labels of the categorys
            categoryLabelList = new String[helperList.size()];
            for(int i = 0; helperList.size() > i; i++) {
                categoryLabelList[i] = helperList.get(i).getLabel();
            }
        }

    }*/
}
