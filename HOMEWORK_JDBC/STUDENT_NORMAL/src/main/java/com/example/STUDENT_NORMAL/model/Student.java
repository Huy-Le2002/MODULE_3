package com.example.STUDENT_NORMAL.model;

public class Student {
    private int id;
    private String name;
    private int age;
    private String specialized;

    public Student() {
    }

    public Student(String name, int age, String specialized) {
        this.name = name;
        this.age = age;
        this.specialized = specialized;
    }

    public Student(int id, String name, int age, String specialized) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.specialized = specialized;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecialized() {
        return specialized;
    }

    public void setSpecialized(String specialized) {
        this.specialized = specialized;
    }
}
