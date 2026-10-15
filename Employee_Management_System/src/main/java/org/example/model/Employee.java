package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Column(name = "email", unique = true, length = 100)
    private String email;
    @Column(name = "department", length = 50)
    private String department;
    @Column(name = "salary")
    private double salary;
    @Column(name = "phone_number", length = 15)
    private String phone_number;

    public Employee() {
    }

    public Employee(long id, String name, String email, String department, double salary, String phone_number) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.salary = salary;
        this.phone_number = phone_number;
    }

    public Employee(String name, String email, String department, double salary, String phone_number) {
        this.name = name;
        this.email = email;
        this.department = department;
        this.salary = salary;
        this.phone_number = phone_number;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}
