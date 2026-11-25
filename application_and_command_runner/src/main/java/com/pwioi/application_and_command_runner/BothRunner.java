package com.pwioi.application_and_command_runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BothRunner implements CommandLineRunner, ApplicationRunner {

    // Application runner will always run first from both runner


    // Command Line Runner
    // ./mvnw clean package
    // java -jar target/project_name.jar test --server.port=8181 --user.id=21 --user.name=Ankit
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Both Runner, Command Line Run");

        for( String s : args){
            if(s.equals("test")){
                System.out.println("test case running");
            }
            System.out.println(s);
        }
    }

    // Application Runner
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Both Runner, Application Run");
        System.out.println(Arrays.toString(args.getSourceArgs()));
        System.out.println(args.getOptionNames());
        System.out.println(args.getOptionValues("server.port"));
        System.out.println(args.containsOption("test"));
        System.out.println(args.getSourceArgs());
        System.out.println(args.getNonOptionArgs());
    }
}
