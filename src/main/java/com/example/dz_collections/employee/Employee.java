package com.example.dz_collections.employee;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Employee {
    @JsonProperty("firstname")
    private String name;
    @JsonProperty("lastname")
    private String surname;

    public Employee() {
        this.name = name;
        this.surname = surname;
    }

    public Employee(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname);
    }
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname());
    }

    @Override
    public String toString() {
        return " ФИО: " + name + " " + surname;
    }
}
