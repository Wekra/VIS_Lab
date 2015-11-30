package de.hska.vis.webshop.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Christian on 26.11.2015.
 */
@Entity
@SequenceGenerator(name="U_ID", initialValue = 1, allocationSize = 1)
@Table(name="user")
public class User implements Serializable {
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private String street;
    private String number;
    private String zip;
    private String city;
    private String country;
    private boolean isAdmin;
    private long user_id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="U_ID", nullable = false)
    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long u_id) {
        this.user_id = u_id;
    }

    @Column(name="PASSWORD", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name="FIRSTNAME", nullable = false)
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Column(name="LASTNAME", nullable = false)
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Column(name="EMAIL", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name="STREET", nullable = false)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Column(name="NUMBER", nullable = false)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Column(name="ZIP", nullable = false)
    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Column(name="CITY", nullable = false)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name="COUNTRY", nullable = false)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name="ISADMIN", nullable = false)
    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String toString(){
        return "Vorname: " + getFirstname() + " Nachname: " + getLastname() + " Email: " + getEmail() + " Straße: " + getStreet()
                + " Hausnummer: " + getNumber() + " PLZ: " + getZip() +  " Ort: " + getCity() + " Land: " + getCountry()
                + " UID: " + getUser_id();
    }



}
