package de.hska.vis.webshop.action;

import com.opensymphony.xwork2.ActionSupport;
import de.hska.vis.webshop.helper.DatabaseQueries;
import de.hska.vis.webshop.model.Category;

import java.util.List;

/**
 * Created by Marcel on 10.12.2015.
 * This class is used as action to delete a category.
 */
public class Delete_Category extends ActionSupport {

    private final DatabaseQueries database;

    public Delete_Category(){
        super();
        database = new DatabaseQueries();
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private long id;

    public Category getCategoryBean() {
        return categoryBean;
    }

    public void setCategoryBean(Category categoryBean) {
        this.categoryBean = categoryBean;
    }

    private Category categoryBean;

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    private List<Category> categoryList;

    public String execute()
    {

        if(!database.allowedToDeleteCategory(id))
        {
            addActionError("Kategorie kann nicht gelöscht werden.");
            categoryList = database.createCategoryList();
            return ERROR;
        }

        if(database.deleteCategory(this.id)){
            return SUCCESS;
        }else{
            return INPUT;
        }
    }
}