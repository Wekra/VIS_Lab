package de.hska.vis.webshop.action;

import com.opensymphony.xwork2.ActionSupport;
import de.hska.vis.webshop.helper.DatabaseQueries;
import de.hska.vis.webshop.model.User;

/**
 * Created by Christian on 25.11.2015.
 */
public class Signup extends ActionSupport {

    DatabaseQueries database;

    public Signup(){
        super();
        database = new DatabaseQueries();
    }

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

        if(database.saveUserToDatabase(userBean)){
            return SUCCESS;
        }else {
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

            User user = null;
            user = database.getUserByEmail(userBean.getEmail());

            if (user != null) {
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
