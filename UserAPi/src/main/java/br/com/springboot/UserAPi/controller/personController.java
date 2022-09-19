package br.com.springboot.UserAPi.controller;

import br.com.springboot.UserAPi.dbInMemory.DbList;
import br.com.springboot.UserAPi.model.Person;
import br.com.springboot.UserAPi.model.User;
import br.com.springboot.UserAPi.repository.personRepository;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequestMapping("/users")
public class personController {
    @GetMapping("/listPerson")
    public List<Person> getPerson() {

        return DbList.getDbList().getPersonList();
    }

    @PostMapping("/registerPerson")
    public ResponseEntity<Person> postPerson(@RequestBody Person person) {

        personRepository.AddLists.AddListPerson(person);

        return ResponseEntity.ok(person);
    }

    @DeleteMapping("/removePerson/{id}")
    public String removePerson(@PathVariable Integer id) {

        if (personRepository.AddLists.RemoveList(id)) {
            return "Ok";
        }

        return "Não Encontrado";
    }

    @GetMapping("findPerson/{name}")
    public static Stream<Person> findPerson(@PathVariable String name) {

        return personRepository.AddLists.findByName(name);
    }

    @GetMapping("findPersoncpf/{cpf}")
    public static Stream<Person> findPersoncpf(@PathVariable String cpf) {
        return personRepository.AddLists.findByCpf(cpf);
    }
    @GetMapping("findPersonid/{id}")
    public static Optional<Person> findPersonid(@PathVariable int id) {
        return personRepository.AddLists.findbyId(id);
    }

    @PutMapping("putPerson/{id}")
    public static Person putPerson(@PathVariable int id, @RequestBody Person _person)
    {
        return personRepository.AddLists.updatePerson(_person, id);
    }



}
