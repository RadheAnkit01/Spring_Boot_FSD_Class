package com.pwioi.radhe.nov23;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "email.student") // we don't need to write for each key, it will mapped to matching attributes.
@Component

public class Email {
    private String id;
    private String name;
    private String course = "B.Tech"; // default value


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
