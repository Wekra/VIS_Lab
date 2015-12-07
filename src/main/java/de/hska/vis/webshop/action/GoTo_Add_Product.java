package de.hska.vis.webshop.action;

import com.opensymphony.xwork2.ActionSupport;
import de.hska.vis.webshop.helper.HibernateUtil;
import de.hska.vis.webshop.model.Category;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Marcel on 07.12.2015.
 */
public class GoTo_Add_Product extends ActionSupport {

    private List<Category> helperList;

    public String[] getCategoryLabelList() {
        return categoryLabelList;
    }

    public void setCategoryLabelList(String[] categoryLabelList) {
        this.categoryLabelList = categoryLabelList;
    }

    private String[] categoryLabelList;
    @Override
    public String execute() {

        helperList = createCategoryList();
        if(helperList == null)
        {
            return INPUT;
        }
        categoryLabelList = new String[helperList.size()];
        for(int i = 0; helperList.size() > i; i++)
        {
            categoryLabelList[i] = helperList.get(i).getLabel();
        }

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
