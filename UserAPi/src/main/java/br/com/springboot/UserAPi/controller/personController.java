package br.com.springboot.UserAPi.controller;

import br.com.springboot.UserAPi.model.Error;
import br.com.springboot.UserAPi.model.Person;
import br.com.springboot.UserAPi.model.User;
import br.com.springboot.UserAPi.repository.personRepository;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequestMapping("/users")
public class personController {
    @GetMapping("/listPerson")
    public ResponseEntity<List<Person>> getPerson() {

        return ResponseEntity.ok(personRepository.getPersonRepository().getTempList());
    }

    @PostMapping("/registerPerson")
    public ResponseEntity postPerson(@RequestBody Person person, Error _erro) {


        if (personRepository.getPersonRepository().AddListPerson(person) == null) {

            _erro.setStatus("Cpf ja existe");

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(_erro);
        }


        return ResponseEntity.ok(person);
    }

    @DeleteMapping("/removePerson/{id}")
    public ResponseEntity removePerson(@PathVariable Integer id, Error _erro) {

        if (personRepository.getPersonRepository().RemoveList(id) != true) {

            _erro.setStatus("Usuário buscado não encontrado");

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(_erro);

        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();


    }

    @GetMapping("findPerson/{name}")
    public ResponseEntity<Stream<Person>> findPerson(@PathVariable String name) {

        return ResponseEntity.ok(personRepository.getPersonRepository().findByName(name));
    }

    @GetMapping("findPersoncpf/{cpf}")
    public ResponseEntity<Stream<Person>> findPersoncpf(@PathVariable String cpf) {
        return ResponseEntity.ok(personRepository.getPersonRepository().findByCpf(cpf));
    }

    @GetMapping("findPersonid/{id}")
    public ResponseEntity<Optional<Person>> findPersonid(@PathVariable int id) {
        return ResponseEntity.ok(personRepository.getPersonRepository().findbyId(id));
    }

    @PutMapping("putPerson/{id}")
    public ResponseEntity putPerson(@PathVariable int id, @RequestBody Person _person, Error erro) {

        try {
            personRepository.getPersonRepository().updatePerson(_person, id);

            return ResponseEntity.status(HttpStatus.CREATED).build();

        } catch (NoSuchElementException nullMsg) {

            erro.setStatus("Id não na url não encontrada");

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);

        } catch (IllegalArgumentException msg){

            erro.setStatus(msg.getMessage());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
        }


    }

}
