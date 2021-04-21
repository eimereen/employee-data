package com.example.employeedata.model;

public class Employee {
    private int id;
    private String name;
    private String position;
    private String datehired;
    private String bday;
    private String address;

    public Employee(){

    }

    public Employee(int id, String name, String position, String datehired, String bday, String address) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.datehired = datehired;
        this.bday = bday;
        this.address = address;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDatehired() {
        return datehired;
    }

    public void setDatehired(String datehired) {
        this.datehired = datehired;
    }

    public String getBday() {
        return bday;
    }

    public void setBday(String bday) {
        this.bday = bday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", datehired='" + datehired + '\'' +
                ", bday='" + bday + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
