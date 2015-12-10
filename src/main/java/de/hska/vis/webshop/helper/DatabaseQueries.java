package de.hska.vis.webshop.helper;

import de.hska.vis.webshop.model.Category;
import de.hska.vis.webshop.model.Product;
import de.hska.vis.webshop.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Christian on 10.12.2015.
 */
public class DatabaseQueries {

    private static SessionFactory sf;

    static {
        sf = HibernateUtil.getSessionFactory();
    }

    private Session session = null;
    private Transaction transaction = null;

    public User getUserByEmail(String email){
        session = sf.getCurrentSession();

        session.beginTransaction();
        String sql = "from User as u where u.email=:mail";
        Query query = session.createQuery(sql);
        query.setParameter("mail", email);
        List<User> list = query.list();
        if (list.size() > 0 ){
            session.close();
            return list.get(0);
        }
        session.close();
        return null;
    }

    public List<Product> createProductList() {
        session = sf.getCurrentSession();

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

    /**
     * Saves a category-object to the database.
     * @param category the category-object to be saved
     * @return true if the save was successful, false otherwise
     */
    public boolean saveCategoryToDatabase(Category category){
        boolean returnValue;
        //saves the category in database
        returnValue = wasSavedToDatabase(category);

        return returnValue;
    }

    /**
     * Helpermethode to saved objects to the database.
     * @param object the objec to be saved
     * @return true if the save was successful, false otherwise
     */
    private boolean wasSavedToDatabase(Object object) {
        boolean returnValue;
        try {
            session = sf.getCurrentSession();
            transaction = session.beginTransaction();
            session.save(object);
            transaction.commit();

            returnValue = true;

        } catch (Exception e){
            System.out.println(e.getMessage());
            returnValue = false;
        }
        return returnValue;
    }

    /**
     * Saves the User-object to the database.
     * @param user
     * @return true if the save was successful, false otherwise.
     */
    public boolean saveUserToDatabase(User user){
        return wasSavedToDatabase(user);
    }

    /**
     * Gives the category with the choosen label
     * @param label String categoryname
     * @return null if category doesn't exist or the category
     */
    public Category getCategoryByLabel(String label){
        session = sf.getCurrentSession();

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

    /**
     * creates a list with all categorys in it
     * @return null if the list is empty or the list
     */
    public List<Category> createCategoryList(){
        session = sf.getCurrentSession();

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

    /**
     * Saves a product-object to the database.
     * @param product
     * @return
     */
    public boolean saveProductToDatabase(Product product){
        return wasSavedToDatabase(product);
    }

    public Product getProductFromId(long nid) {
        session = sf.getCurrentSession();

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

    public List<Product> productSearch(String text, double min, double max) {
        session = sf.getCurrentSession();

        session.beginTransaction();
        String sql = "from Product as u where (u.label like :text or u.description like :text " +
                "or  u.category like :text) and u.price between :min and :max";
        Query query = session.createQuery(sql);
        query.setParameter("text", "%" + text +"%");
        query.setParameter("min",min);
        query.setParameter("max", max);
        List<Product> list = query.list();
        if (list.size() > 0) {
            session.close();
            return list;
        }
        session.close();
        return null;
    }
}
