package com.company.Homework10;

public class User {
    private String name;
    private String post;
    private double salary;

    public User(String name, String post, double salary) {
        this.name = name;
        this.post = post;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", post='" + post + '\'' +
                ", salary=" + salary +
                '}' + "\n";
    }
}
