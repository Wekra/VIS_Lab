package de.hska.vis.webshop.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by Christian on 09.12.2015.
 * This class is used as action to logout the user/admin and redirect to the welcome-page.
 */
public class Logout extends ActionSupport {

    public String execute(){
        return SUCCESS;
    }
}
