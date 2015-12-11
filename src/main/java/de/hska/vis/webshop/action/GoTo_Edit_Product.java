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
public class GoTo_Edit_Product extends ActionSupport {

    public long getSpecialId() {
        return specialId;
    }

    public void setSpecialId(long specialId) {
        this.specialId = specialId;
    }

    private long specialId;


    public Product getOldProductBean() {
        return oldProductBean;
    }

    public void setOldProductBean(Product oldProductBean) {
        this.oldProductBean = oldProductBean;
    }

    private Product oldProductBean;

    public String[] getCategoryLabelList() {
        return categoryLabelList;
    }

    public void setCategoryLabelList(String[] categoryLabelList) {
        this.categoryLabelList = categoryLabelList;
    }

    private String[] categoryLabelList;

    public String getOldCategoryLabel() {
        return oldCategoryLabel;
    }

    public void setOldCategoryLabel(String oldCategoryLabel) {
        this.oldCategoryLabel = oldCategoryLabel;
    }

    private String oldCategoryLabel;

    public String execute()
    {
        List<Category> helperList;

        helperList = createCategoryList();
        if(helperList == null)
        {
            return INPUT;
        }

        //create String Array with the labels of the categorys
        categoryLabelList = new String[helperList.size()];
        for(int i = 0; helperList.size() > i; i++)
        {
            categoryLabelList[i] = helperList.get(i).getLabel();
        }

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = null;
        Transaction transaction = null;

        try {
            session = sf.getCurrentSession();
            transaction = session.beginTransaction();
            oldProductBean = (Product)session.get(Product.class,this.specialId);
            transaction.commit();

        } catch (Exception e){
            System.out.println(e.getMessage());
            return INPUT;
        }
        oldCategoryLabel = getCategory_labelFromId(oldProductBean.getCategory_id());

        return SUCCESS;
    }

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
}
