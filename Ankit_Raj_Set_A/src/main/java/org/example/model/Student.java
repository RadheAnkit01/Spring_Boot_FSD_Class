package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Column(name = "email", unique = true, length = 100)
    private String email;
    @Column(name = "password", unique = false, length = 100)
    private String password;
    @Column(name = "course", length = 100)
    private String course;
    @Column(name = "yearOfStudy", length = 100)
    private String yearOfStudy;

    public Student(String name, String email, String password, String course, String yearOfStudy) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.course = course;
        this.yearOfStudy = yearOfStudy;
    }

    public Student() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(String yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }
}
