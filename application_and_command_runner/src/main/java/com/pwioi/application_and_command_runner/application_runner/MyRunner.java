package com.pwioi.application_and_command_runner.application_runner;

import com.pwioi.application_and_command_runner.User;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class MyRunner implements ApplicationRunner {
    final User user;

    public MyRunner(User user) {
        this.user = user;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Hello From MyRunner");
        System.out.println("UserName from runner : " + user.getName());
    }
}
