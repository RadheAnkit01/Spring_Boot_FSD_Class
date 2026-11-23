package com.pwioi.radhe.nov23;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Nov23Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Nov23Application.class, args);
		Student s1 = context.getBean(Student.class);
		System.out.println(s1.getMail());

		Email e1 = context.getBean(Email.class);
		System.out.println(e1.getId() + " " + e1.getCourse() +  " " + e1.getName());
	}


}
