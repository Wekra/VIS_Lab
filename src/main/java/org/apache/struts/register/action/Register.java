package org.apache.struts.register.action;

/**
 * Created by Christian on 21.11.2015.
 */

import org.apache.struts.register.model.Person;
import com.opensymphony.xwork2.ActionSupport;

public class Register extends ActionSupport {

    private static final long serialVersionUID = 1L;

    private Person personBean;

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    public Person getPersonBean() {
        return personBean;
    }

    public void setPersonBean(Person person){
        personBean = person;
    }

    @Override
    public void validate(){
        if(personBean.getFirstName().length() == 0){
            addFieldError("personBean.firstName", "First name is required.");
        }

        if(personBean.getEmail().length() == 0){
            addFieldError("personBean.email", "Email is required.");
        }

        if(personBean.getAge() < 18){
            addFieldError("personBean.age", "Age is required and must be 18 or older.");
        }
    }
}
