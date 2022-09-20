package br.com.springboot.UserAPi.controller;


import br.com.springboot.UserAPi.model.User;
import br.com.springboot.UserAPi.repository.userRepository;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RequestMapping("/user")
@RestController
public class userController {

    @PostMapping("/logIn")
    public Stream<User> logIn(@RequestBody User _user){

        return userRepository.getUserRepository().LoginUser(_user);
    }

    @PostMapping("/RegisterUser")
    public User registerUser(User _user){

        return userRepository.getUserRepository().registerUser(_user);
    }

}
