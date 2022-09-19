package br.com.springboot.UserAPi.controller;

import br.com.springboot.UserAPi.dbInMemory.DbList;
import br.com.springboot.UserAPi.model.Person;
import br.com.springboot.UserAPi.model.User;
import br.com.springboot.UserAPi.repository.personRepository;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
    public class personController {
    @GetMapping("/listPerson")
        public List<Person> getPerson(){

        return  DbList.getDbList().getPersonList();
        }

        @PostMapping("/registerPerson")
        public Person postPerson(@RequestBody Person person){

            personRepository.AddLists.AddListPerson(person);

            return person;
        }

        @DeleteMapping("/removePerson/{id}")
        public String removePerson(@PathVariable Integer id){

        if(personRepository.AddLists.RemoveList(id)){
            return "Ok";
        }

        return "Não Encontrado";
        }

        @GetMapping("findPerson/{name}")
        public static Person findPerson(@PathVariable String name){

        return personRepository.AddLists.findByName(name);
        }

    @GetMapping("findPersoncpf/{cpf}")
    public static Person findPersoncpf(@PathVariable String cpf){

        return personRepository.AddLists.findByCpf(cpf);
    }

    }
