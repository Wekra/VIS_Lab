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
import de.hska.vis.webshop.helper.HibernateUtil;
import de.hska.vis.webshop.model.User;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class Login extends ActionSupport {


    public String execute() throws Exception {

        User user = null;
        user = getUserByEmail(getEmail());
        if (user == null) return INPUT;

        if(!isPasswordValid(user)) return INPUT;

        return SUCCESS;
    }

    private boolean isInvalid(String value) {
        return (value == null || value.length() == 0);
    }

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

    private User getUserByEmail(String email){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        String sql = "from User as u where u.email=:mail";
        Query query = session.createQuery(sql);
        query.setParameter("mail", email);
        List<User> list = query.list();
        if (list.size() > 0 ){
            session.close();
            return list.get(0);
        }
        session.close();
        return null;
    }



}