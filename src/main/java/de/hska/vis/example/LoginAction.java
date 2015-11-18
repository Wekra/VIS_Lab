package de.hska.vis.example;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by Christian on 18.11.2015.
 */
public class LoginAction extends ActionSupport {

    private String username;

    private String password;

    public String execute() throws Exception {

        if(getUsername().equals("user")){
            if(getPassword().equals("password")){
                return SUCCESS;
            } else {
                addActionError(getText("error.user.passwortforgotten"));
                addActionError("Bitte geben Sie das richtige Passwort ein!");
                return "input";
            }
        } else {
            addActionError(getText("error.username.register"));
            return INPUT;
        }

    }

    public void validate(){
        if(!this.username.startsWith("Us")){
            addFieldError("username", "Username muss mit Us beginnen!");
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passwort) {
        this.password = passwort;
    }
}
