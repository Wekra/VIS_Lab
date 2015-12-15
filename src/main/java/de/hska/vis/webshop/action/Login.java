/*
 * $Id$
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package de.hska.vis.webshop.action;

import com.opensymphony.xwork2.ActionSupport;
import de.hska.vis.webshop.helper.DatabaseQueries;
import de.hska.vis.webshop.model.Product;
import de.hska.vis.webshop.model.User;

import java.util.List;

public class Login extends ActionSupport {
    private final DatabaseQueries database;

    public Login(){
        super();
        database = new DatabaseQueries();
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    private List<Product> productList;

    public String execute() throws Exception {

        User user;
        user = database.getUserByEmail(getEmail());
        if (user == null) return INPUT;

        if(!isPasswordValid(user)) return INPUT;

        if(user.isAdmin()){
            productList = database.createProductList();
            return "admin";
        }

        productList = database.createProductList();

        return SUCCESS;
    }

   /*private boolean isInvalid(String value) {
        return (value == null || value.length() == 0);
    }*/

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private boolean isPasswordValid(User user){
       return user.getPassword().equals(getPassword());
    }

    public void validate(){
        if(getEmail().trim().isEmpty()){
            addFieldError("email", "Dieses Feld darf nicht leer bleiben!");
        }

        if(getPassword().trim().isEmpty()){
            addFieldError("password", "Dieses Feld darf nicht leer bleiben!");
        }
    }
}