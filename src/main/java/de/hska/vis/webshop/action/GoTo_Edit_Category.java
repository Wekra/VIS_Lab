package de.hska.vis.webshop.action;

import com.opensymphony.xwork2.ActionSupport;
import de.hska.vis.webshop.helper.HibernateUtil;
import de.hska.vis.webshop.model.Category;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Marcel on 10.12.2015.
 */
public class GoTo_Edit_Category extends ActionSupport {

    public long getSpecialId() {
        return specialId;
    }

    public void setSpecialId(long specialId) {
        this.specialId = specialId;
    }

    private long specialId;

    public Category getOldCategoryBean() {
        return oldCategoryBean;
    }

    public void setOldCategoryBean(Category oldCategoryBean) {
        this.oldCategoryBean = oldCategoryBean;
    }

    private Category oldCategoryBean;


    public String[] getCategoryLabelList() {
        return categoryLabelList;
    }

    public void setCategoryLabelList(String[] categoryLabelList) {
        this.categoryLabelList = categoryLabelList;
    }

    private String[] categoryLabelList;


    public String execute()
    {
        List<Category> helperList = createCategoryList();

        if (!(helperList == null)){

            //create String Array with the labels of the categorys
            categoryLabelList = new String[helperList.size()];
            for(int i = 0; helperList.size() > i; i++)
            {
                categoryLabelList[i] = helperList.get(i).getLabel();
            }
        }
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = null;
        Transaction transaction = null;

        try {
            session = sf.getCurrentSession();
            transaction = session.beginTransaction();
            oldCategoryBean = (Category) session.get(Category.class,this.specialId);
            transaction.commit();

            return SUCCESS;

        } catch (Exception e){
            System.out.println(e.getMessage());
            return INPUT;
        }
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
}
