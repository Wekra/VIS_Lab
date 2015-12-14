package de.hska.vis.webshop.action;

import com.opensymphony.xwork2.ActionSupport;
import de.hska.vis.webshop.helper.DatabaseQueries;
import de.hska.vis.webshop.model.Category;

import java.util.List;

/**
 * Created by Marcel on 10.12.2015.
 * This class is used as action to redirect to the category-view.
 */
public class GoTo_Category_View extends ActionSupport {

    private final DatabaseQueries database;

    public GoTo_Category_View(){
        super();
        database = new DatabaseQueries();
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    private List<Category> categoryList;

    public String execute()
    {
        categoryList = database.createCategoryList();
        return SUCCESS;
    }
}