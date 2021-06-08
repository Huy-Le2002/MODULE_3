package com.example.End_Module3_L2.model;

public class Staff {
    private int id;
    private String groupstaff;
    private String name;
    private String dob;
    private String phonenumber;
    private String cmnd;
    private String email;
    private String address;

    public Staff() {
    }

    public Staff(String groupstaff) {
        this.groupstaff = groupstaff;
    }

    public Staff(int id, String groupstaff, String name, String dob, String phonenumber, String cmnd, String email, String address) {
        this.id = id;
        this.groupstaff = groupstaff;
        this.name = name;
        this.dob = dob;
        this.phonenumber = phonenumber;
        this.cmnd = cmnd;
        this.email = email;
        this.address = address;
    }

    public Staff(String groupstaff, String name, String dob, String phonenumber, String cmnd, String email, String address) {
        this.groupstaff = groupstaff;
        this.name = name;
        this.dob = dob;
        this.phonenumber = phonenumber;
        this.cmnd = cmnd;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupstaff() {
        return groupstaff;
    }

    public void setGroupstaff(String groupstaff) {
        this.groupstaff = groupstaff;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
