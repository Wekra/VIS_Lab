package de.hska.vis.webshop.action;

import com.opensymphony.xwork2.ActionSupport;
import de.hska.vis.webshop.helper.DatabaseQueries;
import de.hska.vis.webshop.model.Category;

/**
 * Created by Marcel on 07.12.2015.
 */
public class Add_Category extends ActionSupport {

    private DatabaseQueries database;

    public Add_Category(){
        super();
        database = new DatabaseQueries();
    }

    public Category getCategoryBean() {
        return categoryBean;
    }

    public void setCategoryBean(Category categoryBean) {
        this.categoryBean = categoryBean;
    }

    private Category categoryBean;
    @Override
    public String execute() {

        //returns input if the category exists already
        Category category = null;
        category = database.getCategoryByLabel(categoryBean.getLabel());
        if (!(category == null)) return INPUT;

        boolean categoryWasSaved = database.saveCategoryToDatabase(categoryBean);

        if(categoryWasSaved){
            return SUCCESS;
        } else {
            return INPUT;
        }
    }
}
