package de.hska.vis.webshop.helper;

import de.hska.vis.webshop.model.Category;
import de.hska.vis.webshop.model.Product;
import de.hska.vis.webshop.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.jpa.criteria.predicate.BooleanAssertionPredicate;

import java.util.List;

/**
 * Created by Christian on 10.12.2015.
 * This class is used as helper-class to perform all database queries.
 */
public class DatabaseQueries {

    private static final SessionFactory sf;

    static {
        sf = HibernateUtil.getSessionFactory();
    }

    private Session session = null;
    private Transaction transaction = null;

    /**
     * This method gets a User-object from the database identified by the email-value.
     * @param email the email is used as search-criteria
     * @return User-object from the database which matches with the given email
     */
    public User getUserByEmail(String email){
        session = sf.getCurrentSession();

        session.beginTransaction();
        String sql = "from User as u where u.email=:mail";
        Query query = session.createQuery(sql);
        query.setParameter("mail", email);
        java.util.List<User> list = query.list();
        if (list.size() > 0 ){
            session.close();
            return list.get(0);
        }
        session.close();
        return null;
    }

    /**
     * This method is used to create a list of products stored in the database.
     * @return List of product-objects stored in the database
     */
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
     * Helper-method to saved objects to the database.
     * @param object the object to be saved
     * @return true if the save was successful, false otherwise
     */
    private boolean wasSavedToDatabase(Object object) {
        boolean returnValue;
        try {
            session = sf.getCurrentSession();
            Transaction transaction = session.beginTransaction();
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
     * @param user the User-object to be saved
     * @return true if the save was successful, false otherwise.
     */
    public boolean saveUserToDatabase(User user){
        return wasSavedToDatabase(user);
    }

    /**
     * Gives the category with the chosen label
     * @param label the name of the category as <code>String</code>
     * @return null if category doesn't exist or the category
     */
    public Category getCategoryByLabel(String label){
        session = sf.getCurrentSession();

        session.beginTransaction();
        String sql = "from Category as u where u.label=:label";
        Query query = session.createQuery(sql);
        query.setParameter("label", label);
        java.util.List<Category> list = query.list();
        if (list.size() > 0 ){
            session.close();
            return list.get(0);
        }
        session.close();
        return null;
    }

    /**
     * creates a list with all categories in it
     * @return null if the list is empty or the list
     */
    public List<Category> createCategoryList(){
        session = sf.getCurrentSession();

        session.beginTransaction();
        String sql = "from Category ";
        Query query = session.createQuery(sql);
        java.util.List<Category> list = query.list();
        if (list.size() > 0) {
            session.close();
            return list;
        }
        session.close();
        return null;
    }

    /**
     * Saves a product-object to the database.
     * @param product the product-object to be saved
     * @return true if the product was saved successful, otherwise false
     */
    public boolean saveProductToDatabase(Product product){
        return wasSavedToDatabase(product);
    }

    public Product getProductFromId(long nid) {
        session = sf.getCurrentSession();

        session.beginTransaction();
        Product product=(Product)session.get(Product.class, nid);

        session.close();
        return product;
    }

    /**
     * This method is used to search in the database.
     * @param text the text to be searched as <code>String</code>
     * @param min the minimum price as <code>double</code>
     * @param max the maximum price as <code>double</code>
     * @return a List of products which match the given search-parameters
     */
    public List<Product> productSearch(String text, double min, double max) {
        session = sf.getCurrentSession();

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
        if (list.size() > 0) {
            session.close();
            return list;
        }
        session.close();
        return null;
    }

    /**
     * Gives the product with the chosen label
     * @param label String with the product name
     * @return null if product doesn't exist or the product
     */
    public Product getProductByLabel(String label)
    {
        session = sf.getCurrentSession();

        session.beginTransaction();
        String sql = "from Product as u where u.label=:label";
        Query query = session.createQuery(sql);
        query.setParameter("label", label);
        @SuppressWarnings("unchecked")
        List<Product> list = query.list();
        if (list.size() > 0 ){
            session.close();
            return list.get(0);
        }
        session.close();
        return null;
    }

    /**
     * Gets the category_label with category_id
     * @param category_id long
     * @return String category_label
     */
    public String getCategory_labelFromId(long category_id)
    {
        session = sf.getCurrentSession();
        session.beginTransaction();

        Category category =(Category)session.get(Category.class, category_id);

        session.close();
        return category.getLabel();
    }

    /**
     * gets the category_id from the category label
     * @param label String the category label
     * @return long the category_id
     */
    public long getCategory_idFromLabel(String label)
    {
        session = sf.getCurrentSession();

        session.beginTransaction();
        String sql = "from Category as u where u.label=:label";
        Query query = session.createQuery(sql);
        query.setParameter("label", label);
        List<Category> list = query.list();

        return list.get(0).getCategory_id();
    }

    /**
     * Looks up, if the label is used in any product.
     * @param id The id of the label to be examined.
     * @return true if the label is not used in a product, false otherwise
     */
    public boolean allowedToDeleteCategory(long id)
    {
       session = sf.getCurrentSession();

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

    /**
     * Deletes the category with the given ID.
     * @param id The ID of the category to be deleted.
     * @return true if the delete was successful, false otherwise
     */
    public boolean deleteCategory(long id){
        Category categoryBean;

        try {
            session = sf.getCurrentSession();
            transaction = session.beginTransaction();
            categoryBean = (Category) session.get(Category.class, id);
            session.delete(categoryBean);
            transaction.commit();

            return true;

        } catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Deletes the product with the given ID.
     * @param specialId The ID of the product to be deleted.
     * @return true if the delete was successful, false otherwise
     */
    public boolean deleteProduct(long specialId){
        Product product;

        try {
            session = sf.getCurrentSession();
            transaction = session.beginTransaction();
            product = (Product) session.get(Product.class, specialId);
            session.delete(product);
            transaction.commit();

            return true;

        } catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Looks up, if the category with the given name does exist
     * @param newLabel The name of the category to look up.
     * @return true if the category exists, false otherwise
     */
    public boolean doesCategoryExist(String newLabel)
    {
        session = sf.getCurrentSession();

        session.beginTransaction();
        String sql = "from Category as u where u.label=:label";
        Query query = session.createQuery(sql);
        query.setParameter("label", newLabel);
        List<Category> list = query.list();

        if(list.size() >0)
        {
            return true;
        }
        return false;
    }

    /**
     * Updates the given category.
     * @param categoryBean the Category-object to be updated.
     * @return true if the update was successful, false otherwise
     */
    public boolean updateCategory(Category categoryBean){

        try {
            session = sf.getCurrentSession();
            transaction = session.beginTransaction();
            session.update(categoryBean);
            transaction.commit();

            return true;

        } catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Updates the given product.
     * @param productBean the Product-object to be updated.
     * @return true if the update was successful, false otherwise
     */
    public boolean updateProduct(Product productBean){
        boolean returnValue;
        try {
            session = sf.getCurrentSession();
            transaction = session.beginTransaction();
            session.update(productBean);
            transaction.commit();

            returnValue = true;

        } catch (Exception e){
            System.out.println(e.getMessage());
            returnValue = false;
        }
        return returnValue;
    }

    /**
     * Gets the old category from the given id.
     * @param specialId the id of the category
     * @return the Category-object with the given id
     */
    public Category getOldCategory(long specialId){
        Category oldCategoryBean = null;
        try {
            session = sf.getCurrentSession();
            transaction = session.beginTransaction();
            oldCategoryBean = (Category) session.get(Category.class,specialId);
            transaction.commit();

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return oldCategoryBean;
    }

    public Product getOldProduct(long specialId){
        Product oldProductBean = null;

        try {
            session = sf.getCurrentSession();
            transaction = session.beginTransaction();
            oldProductBean = (Product) session.get(Product.class, specialId);
            transaction.commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return oldProductBean;
    }
}