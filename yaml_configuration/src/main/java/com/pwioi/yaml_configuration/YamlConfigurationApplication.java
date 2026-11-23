package com.pwioi.yaml_configuration;

import com.pwioi.yaml_configuration.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class YamlConfigurationApplication {

	public static void main(String[] args) {
//		Using Application Context and getBean

		ApplicationContext context =  SpringApplication.run(YamlConfigurationApplication.class, args);
//		User user = context.getBean(User.class);
//		System.out.println("User : " + "Name " + user.getName() + ", City " + user.getCity());

	}

}
