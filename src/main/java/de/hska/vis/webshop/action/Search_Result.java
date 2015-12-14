package de.hska.vis.webshop.action;

import com.opensymphony.xwork2.ActionSupport;
import de.hska.vis.webshop.helper.DatabaseQueries;
import de.hska.vis.webshop.model.Product;

import java.util.List;

/**
 * Created by Marcel on 08.12.2015.
 * This class is used as action to display the results of a performed search.
 */
public class Search_Result extends ActionSupport {

    private final DatabaseQueries database;

    public Search_Result() {
        super();
        database = new DatabaseQueries();
    }

    private String searchText;

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    private double minPrice;

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    private double maxPrice;

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    private List<Product> productList;

    public String execute() {
        if (maxPrice <= 0) maxPrice = 1000000;
        productList = database.productSearch(searchText, minPrice, maxPrice);
        return SUCCESS;
    }
}
