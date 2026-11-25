package com.pwioi.application_and_command_runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ApplicationAndCommandRunnerApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ApplicationAndCommandRunnerApplication.class, args);
		User user = context.getBean(User.class);
		System.out.println(user.getId());
		System.out.println(user.getName());
	}

	//Terminal Command Line Arguments - Highest priority (override properties file)
	// ./mvnw clean package
	// java -jar target/project_name.jar test --server.port=8181 --user.id=21 --user.name=Ankit


	// Non-Optional Args (comes without value) -> debug, test
	// Optional Args (comes with value)-> --server.port=8080, --user.id=424

}
