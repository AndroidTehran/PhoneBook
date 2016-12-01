package com.pouya11.phonebook.models;

/**
 * Created by Mohammad on 01/12/2016.
 */
public class PhoneRecord {
    private String name;
    private String family;
    private String phone;
    private String email;

    public PhoneRecord(){ // default constructor

    }
    public PhoneRecord(String name, String family, String phone, String email){
        this.setName(name);
        this.setFamily(family);
        this.setPhone(phone);
        this.setEmail(email);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
