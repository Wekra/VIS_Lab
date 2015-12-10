package de.hska.vis.webshop.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by Marcel on 10.12.2015.
 */
public class GoTo_Edit_Product extends ActionSupport {

    public long getSpecialId() {
        return specialId;
    }

    public void setSpecialId(long specialId) {
        this.specialId = specialId;
    }

    private long specialId;

    public String execute()
    {


        return SUCCESS;
    }
}
