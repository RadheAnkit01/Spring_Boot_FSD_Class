package com.pwioi.yaml_configuration.utility;

import com.pwioi.yaml_configuration.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class PrintUserRunner implements ApplicationRunner {
    private User user;

    @Autowired
    public PrintUserRunner(User user) {
        this.user = user;
    }
    //
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("User : " + user.getName() + " " + user.getCity());
    }
}


