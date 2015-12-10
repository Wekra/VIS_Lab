package de.hska.vis.webshop.action;

import com.opensymphony.xwork2.ActionSupport;
import de.hska.vis.webshop.helper.HibernateUtil;
import de.hska.vis.webshop.model.Category;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Marcel on 10.12.2015.
 */
public class GoTo_Category_View extends ActionSupport {

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    private List<Category> categoryList;

    public String execute()
    {
        categoryList = createCategoryList();
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


}
