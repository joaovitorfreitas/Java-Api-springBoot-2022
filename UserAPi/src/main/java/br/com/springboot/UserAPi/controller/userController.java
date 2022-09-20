package br.com.springboot.UserAPi.controller;


import br.com.springboot.UserAPi.model.Error;
import br.com.springboot.UserAPi.model.User;
import br.com.springboot.UserAPi.repository.userRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
public class userController {

    @PostMapping("/RegisterUser")
    public ResponseEntity registerUser(@RequestBody User _user){

        if(userRepository.getUserRepository().registerUser(_user) != null){
            return ResponseEntity.ok(_user);
        }


        return ResponseEntity.badRequest().body(new Error("Cpf já existente"));
    }

}
