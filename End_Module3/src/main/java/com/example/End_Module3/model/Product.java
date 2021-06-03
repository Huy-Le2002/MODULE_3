package com.example.End_Module3.model;

public class Product {
    private int id;
    private String productName;
    private float price;
    private int quantity;
    private String color;
    private String des;
    private int cateGory;
    private String cateGoryName;

    public Product() {
    }

    public Product(int id, String productName, float price, int quantity, String color, String cateGoryName) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.cateGoryName = cateGoryName;
    }

    public Product(int id, String productName, float price, int quantity, String color, String des, int cateGory, String cateGoryName) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.des = des;
        this.cateGory = cateGory;
        this.cateGoryName = cateGoryName;
    }

    public Product(int id, String productName, float price, int quantity, String color, String des, int cateGory) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.des = des;
        this.cateGory = cateGory;
    }

    public Product(String productName, float price, int quantity, String color, int cateGory) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.cateGory = cateGory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getCateGory() {
        return cateGory;
    }

    public void setCateGory(int cateGory) {
        this.cateGory = cateGory;
    }

    public String getCateGoryName() {
        return cateGoryName;
    }

    public void setCateGoryName(String cateGoryName) {
        this.cateGoryName = cateGoryName;
    }
}
