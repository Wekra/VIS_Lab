package de.hska.vis.webshop.action;

import com.opensymphony.xwork2.ActionSupport;
import de.hska.vis.webshop.helper.DatabaseQueries;
import de.hska.vis.webshop.model.Category;

import java.util.List;

/**
 * Created by Marcel on 07.12.2015.
 */
public class GoTo_Add_Product extends ActionSupport {

    private DatabaseQueries database;

    public GoTo_Add_Product(){
        super();
        database = new DatabaseQueries();
    }

    private List<Category> helperList;

    public String[] getCategoryLabelList() {
        return categoryLabelList;
    }

    public void setCategoryLabelList(String[] categoryLabelList) {
        this.categoryLabelList = categoryLabelList;
    }

    private String[] categoryLabelList;

    @Override
    public String execute() {

        helperList = database.createCategoryList();
        if(helperList == null)
        {
            return INPUT;
        }

        //create String Array with the labels of the categorys
        categoryLabelList = new String[helperList.size()];
        for(int i = 0; helperList.size() > i; i++)
        {
            categoryLabelList[i] = helperList.get(i).getLabel();
        }

        return SUCCESS;
    }
}
