/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cc.beans;

/**
 *
 * @author Louis
 */
public class Customer {
    /* Propriétés du bean */
    private String lastname;
    private String firstname;
    private String address;
    private String phone;
    private String email;

    public void setLastname( String lastname ) {
        this.lastname = lastname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setFirstname( String firstname ) {
        this.firstname = firstname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setAddress( String address ) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone( String phone ) {
        this.phone = phone;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
