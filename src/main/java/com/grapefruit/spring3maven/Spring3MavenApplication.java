package com.grapefruit.spring3maven;

import com.grapefruit.spring3maven.entity.User;
import com.grapefruit.spring3maven.exception.MyException;
import com.grapefruit.spring3maven.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Spring3MavenApplication {

    public static void main(String[] args) {
        SpringApplication.run(Spring3MavenApplication.class, args);
    }

    @Autowired
    private UserService userService;

    @Bean
    public CommandLineRunner commandLineRunner() {
        User user = new User("0", "grape", "GZ");
        try {
            userService.saveUser(user);
        } catch (MyException e) {
            throw new RuntimeException(e);
        }

        User user1 = new User("1", "fruit", "MZ");
        //userService.saveUser(user1);

        User userById = userService.getUserById("0");

        System.out.println();
        return (args) -> {
        };
    }

}
