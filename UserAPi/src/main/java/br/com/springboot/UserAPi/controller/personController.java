package br.com.springboot.UserAPi.controller;

import br.com.springboot.UserAPi.dbInMemory.DbList;
import br.com.springboot.UserAPi.model.Person;
import br.com.springboot.UserAPi.model.User;
import br.com.springboot.UserAPi.repository.personRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
    public class personController {

    private static List<User> ttt =  new ArrayList<>();

    @GetMapping("/listPerson")
        public List<Person> getPerson(){

        return  DbList.getDbList().getPersonList();
        }

        @PostMapping("/registerPerson")
        public Person postPerson(@RequestBody Person person){

            personRepository.AddLists.AddListPerson(person);

            return person;
        }


    }
