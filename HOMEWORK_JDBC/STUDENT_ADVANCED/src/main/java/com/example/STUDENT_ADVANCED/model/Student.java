package com.example.STUDENT_ADVANCED.model;

public class Student {
    private int id;
    private String name;
    private int age;
    private int specialized_id;
    private String specialized_name;

    public Student() {
    }

    public Student(String name, int age, int specialized_id) {
        this.name = name;
        this.age = age;
        this.specialized_id = specialized_id;
    }

    public Student(int id, String name, int age, int specialized_id) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.specialized_id = specialized_id;
    }

    public Student(int id, String name, int age, int specialized_id, String specialized_name) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.specialized_id = specialized_id;
        this.specialized_name = specialized_name;
    }

    public Student(String name, int age, int specialized_id, String specialized_name) {
        this.name = name;
        this.age = age;
        this.specialized_id = specialized_id;
        this.specialized_name = specialized_name;
    }

    public Student(int id, String name, int age, String specialized_name) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.specialized_name = specialized_name;
    }

    public String getSpecialized_name() {
        return specialized_name;
    }

    public void setSpecialized_name(String specialized_name) {
        this.specialized_name = specialized_name;
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

    public int getSpecialized_id() {
        return specialized_id;
    }

    public void setSpecialized_id(int specialized_id) {
        this.specialized_id = specialized_id;
    }
}
