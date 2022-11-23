package com.example.renter_2;

public class model
{
    String name, fore, rent, phone, location, description;

    public model() {
    }

    public model(String name, String fore, String house_rent, String phone, String location, String description) {
        this.name = name;
        this.fore = fore;
        this.rent = house_rent;
        this.phone = phone;
        this.location = location;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFore() {
        return fore;
    }

    public void setFore(String fore) {
        this.fore = fore;
    }

    public String getRent() {
        return rent;
    }

    public void setRent(String rent) {
        this.rent = rent;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
