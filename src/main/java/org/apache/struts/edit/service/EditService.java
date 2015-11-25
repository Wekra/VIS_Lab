package org.apache.struts.edit.service;

/**
 * Created by Christian on 24.11.2015.
 */
import org.apache.struts.edit.model.Person;

public interface EditService {

    Person getPerson() ;

    void savePerson(Person personBean);

}