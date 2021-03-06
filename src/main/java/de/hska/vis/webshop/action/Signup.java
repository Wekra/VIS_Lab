package de.hska.vis.webshop.action;

import com.opensymphony.xwork2.ActionSupport;
import de.hska.vis.webshop.helper.DatabaseQueries;
import de.hska.vis.webshop.model.User;

/**
 * Created by Christian on 25.11.2015.
 * This class is used as action to sign-up as a new user.
 */
public class Signup extends ActionSupport {

    private final DatabaseQueries database;

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

        if(database.saveUserToDatabase(userBean)){
            return SUCCESS;
        }else {
            return INPUT;
        }
    }

    /**
     * Validates the input entered to the text-fields on the sign-up page.
     */
    @Override
    public void validate(){
        // validate Password
        if(userBean.getPassword().trim().isEmpty()) {
            addFieldError("userBean.password", "Sie benötigen ein Passwort!");
        }else if(userBean.getPassword().length() < 8) {
            addFieldError("userBean.password", "Das Passwort sollte mindestens 8 Zeichen lang sein.");
        }

        // validate Email (Username)
        if(userBean.getEmail().trim().isEmpty() || !(userBean.getEmail().contains("@"))){
            addFieldError("userBean.email","Bitte geben Sie eine E-Mail Adresse an.");
        }else {

            User user;
            user = database.getUserByEmail(userBean.getEmail());

            if (user != null) {
                addFieldError("userBean.email", "Diese E-Mail ist bereits einem anderen User zugeordnet.");
            }
        }

        // validate others
        if(userBean.getCity().trim().isEmpty()){
            addFieldError("userBean.city","Bitte geben Sie Ihren Wohnort an.");
        }


        if(userBean.getCountry().trim().isEmpty()){
            addFieldError("userBean.country","Bitte geben Sie ein Land an.");
        }

        if(userBean.getFirstname().trim().isEmpty()){
            addFieldError("userBean.firstname","Bitte geben Sie Ihren Vornamen an.");
        }

        if(userBean.getLastname().trim().isEmpty()){
            addFieldError("userBean.lastname","Bitte geben Sie Ihren Nachnamen an.");
        }

        if(userBean.getNumber().trim().isEmpty()){
            addFieldError("userBean.number","Bitte geben Sie Ihre Hausnummer an.");
        }

        if(userBean.getStreet().trim().isEmpty()){
            addFieldError("userBean.street","Bitte geben Sie Ihre Adresse an.");
        }

        if(userBean.getZip().trim().isEmpty()){
            addFieldError("userBean.zip","Bitte geben Sie ihre Postleitzahl an.");
        }
    }
}
