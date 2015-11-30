package de.hska.vis.webshop.action;

import com.opensymphony.xwork2.ActionSupport;
import de.hska.vis.webshop.helper.HibernateUtil;
import de.hska.vis.webshop.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Created by Christian on 25.11.2015.
 */
public class Signup extends ActionSupport {

    private static final long serialVersionUID = 1L;

    public User getUserBean() {
        return userBean;
    }

    public void setUserBean(User userBean) {
        this.userBean = userBean;
    }

    private User userBean;

    public String execute() throws Exception {
       /* User user = new User();
        user.setFirstname(userBean.getFirstname());
        user.setLastname(userBean.getLastname());*/

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = null;
        Transaction transaction = null;

        try {
            session = sf.getCurrentSession();
            transaction = session.beginTransaction();
            session.save(userBean);
            transaction.commit();
            return SUCCESS;

        } catch (Exception e){
            System.out.println(e.getMessage());
            return INPUT;
        }

    }

    public void validate(){

    }
}
