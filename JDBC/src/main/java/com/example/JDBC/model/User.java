package com.example.JDBC.model;

public class User {
    protected int id;
    protected String name;
    protected String email;
    protected int id_country;
    protected String countryName;


    public User() {
    }

    public User(int id, String name, String email, String countryName) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.countryName = countryName;
    }

    public User(int id, String name, String email, int id_country) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.id_country = id_country;
    }

    public User(String name, String email, int id_country) {
        this.name = name;
        this.email = email;
        this.id_country = id_country;
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
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId_country() {
        return id_country;
    }

    public void setId_country(int id_country) {
        this.id_country = id_country;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
