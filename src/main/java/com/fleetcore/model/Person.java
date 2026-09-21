
package com.fleetcore.model;

import com.fleetcore.util.Validator;

/**
 *
 * @author mlamu
 */
public abstract class Person {
    private int id;
    private String name;
    private String phone;
    private String email;

    protected Person(String name, String phone, String email) {
        this(0, name, phone, email);
    }

    protected Person(int id, String name, String phone, String email) {
        Validator.requireNotBlank(name, "Name");
        Validator.requireNotBlank(phone, "Phone");
        Validator.requireNotBlank(email, "Email");
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Validator.requireNotBlank(name, "Name");
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        Validator.requireNotBlank(phone, "Phone");
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        Validator.requireNotBlank(email, "Email");
        this.email = email;
    }
    
    public final String getDescription() {
        return " [" + id + "]" + getSpecificDetails();
    }
    
    protected abstract String getSpecificDetails();
}
