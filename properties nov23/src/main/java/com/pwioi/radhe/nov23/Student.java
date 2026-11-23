package com.pwioi.radhe.nov23;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
//Bean vs Component
//Bean - > humlog khud se object banakar dete hai aur IOC container ushe manage karta hai.
//Component - > yeh kuch se hi object bana deta hai aur IOC container ushe manage karta hai.

@Component
public class Student {
    private String name;
    private String college;
    private String mail;
    private String city;

//   use  @Value("${student.college:PWIOI}") with default value

    public Student(@Value("${student.name}") String name, @Value("${student.college:PWIOI}")String college, @Value("${student.mail}")String mail, @Value("${student.city}")String city) {
        this.name = name;
        this.college = college;
        this.mail = mail;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
