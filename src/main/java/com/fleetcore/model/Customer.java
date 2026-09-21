
package com.fleetcore.model;

import com.fleetcore.util.Validator;

/**
 *
 * @author mlamu
 */
public class Customer extends Person{
    private String companyName;
    private String address;

    public Customer(String companyName, String address, String name, String phone, String email) {
        this(companyName, address, 0, name, phone, email);
    }

    public Customer(String companyName, String address, int id, String name, String phone, String email) {
        super(id, name, phone, email);
        Validator.requireNotBlank(companyName, "Company name");
        Validator.requireNotBlank(address, "Address");
        this.companyName = companyName;
        this.address = address;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        Validator.requireNotBlank(companyName, "Company name");
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        Validator.requireNotBlank(address, "Address");
        this.address = address;
    }

    @Override
    protected String getSpecificDetails() {
        String details;
        details = "Company: " + companyName + 
                " | Name: " + getName() + 
                " | Email: " + getEmail() + 
                " | Phone: " + getPhone() + 
                " | Address: " + getAddress();
        return details;
    }
}
