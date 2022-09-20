package br.com.springboot.UserAPi.repository;

import br.com.springboot.UserAPi.model.Person;
import br.com.springboot.UserAPi.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;


@Getter
public class personRepository {
    private List<Person> tempList;
    private Integer id = 1;
    private static personRepository _person;

    private personRepository() {
        tempList = new ArrayList<>();
    }

    // Sigleton
    public static personRepository getPersonRepository() {

        if (_person == null) {
            _person = new personRepository();
        }

        return _person;
    }

    private Boolean checkCpf(String cpf) {
        return tempList.stream().filter(person -> person.getCpf().equals(cpf)).count() > 0;
    }

    public Person AddListPerson(Person _person) {

        if (checkCpf(_person.getCpf())) {

            return null;
        }

        _person.setId(id++);

        tempList.add(_person);

        return _person;

    }

    public boolean RemoveList(Integer idFind) {
        return tempList.removeIf(person -> person.getId() == idFind);
    }


    public Stream<Person> findByName(String name) {

        return tempList.stream().filter(person -> person.getName().equalsIgnoreCase(name));
    }


    public Stream<Person> findByCpf(String cpf) {

        return tempList.stream().filter(person -> person.getCpf().contains(cpf));
    }

    public Optional<Person> findbyId(int id) {

        return tempList.stream().filter(person -> person.getId() == id).findFirst();

    }

    public Person updatePerson(Person _person, int id) {

        Optional<Person> optPerson = findbyId(id);

        if (optPerson.isEmpty()) {
            throw new NullPointerException("Id não na url não encontrada");
        }

        Person person = optPerson.get();

        if (_person.getId() == null) {
            _person.setId(person.getId());
        } else if (person.getId() != _person.getId()) {
            throw new IllegalArgumentException("Id não no corpo não valido");
        }

        person.setNumberHome(_person.getNumberHome());
        person.setName(_person.getName());
        person.setStreet(_person.getStreet());
        person.setComplement(_person.getComplement());
        person.setRg(_person.getRg());
        person.setUf(_person.getUf());
        person.setDistrict(_person.getDistrict());
        person.setCounty(_person.getCounty());
        person.setCpf(_person.getCpf());

        return _person;
    }
}


