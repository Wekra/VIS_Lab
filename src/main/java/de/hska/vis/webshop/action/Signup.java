package de.hska.vis.webshop.action;

import com.opensymphony.xwork2.ActionSupport;
import de.hska.vis.webshop.helper.HibernateUtil;
import de.hska.vis.webshop.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;

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

    /**
     * Validates the input in the textfields on the signup page.
     */
    @Override
    public void validate(){
        // validate Password
        if(userBean.getPassword().length() == 0) {
            addFieldError("userBean.password", "Password is Required");
        }else if(userBean.getPassword().length() < 8) {
            addFieldError("userBean.password", "Password has to be at least eight characters long");
        }

        // validate Email (Username)
        if(userBean.getEmail().length() == 0){
            addFieldError("userBean.email","Email is Required");
        }else {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();

            session.beginTransaction();

            String sql = "from User as u where u.email=:mail";
            Query query = session.createQuery(sql);
            query.setParameter("mail", userBean.getEmail());
            List<User> list = query.list();

            session.close();

            if (list.size() > 0) {
                addFieldError("userBean.email", "E-mail address already exists");
            }
        }

        // validate others
        if(userBean.getCity().length() == 0){
            addFieldError("userBean.city","City is Required");
        }


        if(userBean.getCountry().length() == 0){
            addFieldError("userBean.country","Country is Required");
        }

        if(userBean.getFirstname().length() == 0){
            addFieldError("userBean.firstname","Firstname is Required");
        }

        if(userBean.getLastname().length() == 0){
            addFieldError("userBean.lastname","Lastname is Required");
        }

        if(userBean.getNumber().length() == 0){
            addFieldError("userBean.number","Number is Required");
        }

        if(userBean.getStreet().length() == 0){
            addFieldError("userBean.street","Street is Required");
        }

        if(userBean.getZip().length() == 0){
            addFieldError("userBean.zip","Zip is Required");
        }
    }
}