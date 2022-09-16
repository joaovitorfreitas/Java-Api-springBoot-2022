package br.com.springboot.UserAPi.controller;

import br.com.springboot.UserAPi.dbInMemory.DbList;
import br.com.springboot.UserAPi.model.Person;
import br.com.springboot.UserAPi.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
    public class personController {

    public  List<User> users1 = new ArrayList<>();

    @GetMapping("/")
        public List<Person> get(){

        return  DbList.AllLists.person;
        }

        @PostMapping("/regis")
        public Person user(@RequestBody Person person){

            DbList.AllLists.ListPerson(person);

            return person;
        }



    }
