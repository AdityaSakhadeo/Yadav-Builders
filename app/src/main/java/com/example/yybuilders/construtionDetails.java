package com.example.yybuilders;

public class construtionDetails {
    public String site_name;
    public String site_address;
    public String width;
    public String height;
    public String owner_name;
    public String owner_contact;

    public construtionDetails(String site_name, String site_address, String width, String height, String owner_name, String owner_contact) {
        this.site_name = site_name;
        this.site_address = site_address;
        this.width = width;
        this.height = height;
        this.owner_name = owner_name;
        this.owner_contact = owner_contact;
    }

    public construtionDetails()
    {}


    public String getSite_name() {
        return site_name;
    }

    public void setSite_name(String site_name) {
        this.site_name = site_name;
    }

    public String getSite_address() {
        return site_address;
    }

    public void setSite_address(String site_address) {
        this.site_address = site_address;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public String getOwner_contact() {
        return owner_contact;
    }

    public void setOwner_contact(String owner_contact) {
        this.owner_contact = owner_contact;
    }
}
