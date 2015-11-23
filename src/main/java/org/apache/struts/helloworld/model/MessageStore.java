package org.apache.struts.helloworld.model;

/**
 * Created by Christian on 18.11.2015.
 */
public class MessageStore {
    private String message;
    public MessageStore(){
        setMessage("Hello Struts User");
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String toString() {
        return message + " (from toString)";
    }
}
