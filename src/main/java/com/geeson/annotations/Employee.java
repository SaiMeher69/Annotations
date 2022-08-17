package com.geeson.annotations;

import com.google.gson.annotations.SerializedName;

public class Employee {
    //@NameToName(value = "empName")
    //@SerializedName(value = "empName", alternate = "name")
    String name;
    @NameToName(value = "empJobTitle")
    String jobTitle;
    @NameToName(value = "empId")
    int id;
    @NameToName(value = "empAge")
    int age;
    @NameToName(value = "empSalary")
    int salary;

    public Employee(){
        this.name = "";
        this.age = 0;
        this.id = 0;
        this.jobTitle = "";
        this.salary = 0;
    }

    public Employee(String name, String jobTitle, int id, int age, int salary) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.id = id;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", id=" + id +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
