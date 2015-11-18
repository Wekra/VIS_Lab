package org.apache.struts.helloworld.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts.helloworld.model.MessageStore;

/**
 * Created by Christian on 18.11.2015.
 */
public class HelloWorldAction extends ActionSupport {

    private static final long serialVersionUID = 1L;

    private MessageStore messageStore;

    public String execute() throws Exception {

        messageStore = new MessageStore();
        return SUCCESS;
    }

    public MessageStore getMessageStore() {
        return messageStore;
    }

    public void setMessageStore(MessageStore messageStore){
        this.messageStore = messageStore;
    }
}
