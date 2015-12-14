package de.hska.vis.webshop.action;

import com.opensymphony.xwork2.ActionSupport;
import de.hska.vis.webshop.helper.DatabaseQueries;
import de.hska.vis.webshop.model.Category;

import java.util.List;

/**
 * Created by Marcel on 07.12.2015.
 * This class is used to add a new product to the webshop.
 */
public class GoTo_Add_Product extends ActionSupport {

    private final DatabaseQueries database;

    public GoTo_Add_Product(){
        super();
        database = new DatabaseQueries();
    }

    public String[] getCategoryLabelList() {
        return categoryLabelList;
    }

    public void setCategoryLabelList(String[] categoryLabelList) {
        this.categoryLabelList = categoryLabelList;
    }

    private String[] categoryLabelList;

    @Override
    public String execute() {

        List<Category> helperList = database.createCategoryList();
        if(helperList == null)
        {
            return INPUT;
        }

        //create String Array with the labels of the categories
        categoryLabelList = new String[helperList.size()];
        for(int i = 0; helperList.size() > i; i++)
        {
            categoryLabelList[i] = helperList.get(i).getLabel();
        }

        return SUCCESS;
    }
}
