package br.com.springboot.UserAPi.repository;

import br.com.springboot.UserAPi.dbInMemory.DbList;
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
@NoArgsConstructor
public class personRepository {
    private List<Person> tempList;
    private Integer id = 1;


    //Lista
    private static personRepository _person;


    // Sigleton
    public static personRepository getPersonRepository() {

        if (_person == null) {

            _person = new personRepository();
        }

        return _person;
    }


    //Metodos
    private Boolean checkCpf(String cpf) {

        if (tempList.stream().filter(person -> person.getCpf().equals(cpf)).count() == 1) {
            return true;
        }

        return false;
    }

    public Person AddListPerson(Person _person) {

        if (tempList == null) {

            tempList = new ArrayList<>();
        }

        if (checkCpf(_person.getCpf())) {

            return null;
        }

        _person.setId(id++);

        tempList.add(_person);

        return _person;

    }

    public boolean RemoveList(Integer idFind) {

        for (int i = 0; i < tempList.size(); i++) {

            if (tempList.get(i).getId() == idFind) {

                tempList.removeIf(person -> person.getId() == idFind);

                return Boolean.TRUE;
            }
        }

        return Boolean.FALSE;
    }


    public Stream<Person> findByName(String name) {

        if (tempList.stream().filter(person -> person.getName().equalsIgnoreCase(name)).count() == 1) {
            return tempList.stream().filter(person -> person.getName().equalsIgnoreCase(name));
        }

        return null;
    }


    public Stream<Person> findByCpf(String cpf) {

        if (tempList.stream().filter(person -> person.getCpf().contains(cpf)).count() == 1) {
            return tempList.stream().filter(person -> person.getCpf().contains(cpf));
        }

        return null;
    }

    public Optional<Person> findbyId(int id) {

        return tempList.stream().filter(person -> person.getId() == id).findFirst();

    }

    public Person updatePerson(Person _person, int id) {

        if (findbyId(id) == null) {
            return null;
        }

        if (_person.getId() == null) {
            _person.setId(findbyId(id).get().getId());
        } else if (findbyId(id).get().getId() != _person.getId()) {
            throw new IllegalArgumentException("Id não valido");
        }

        findbyId(id).get().setNumberHome(_person.getNumberHome());
        findbyId(id).get().setName(_person.getName());
        findbyId(id).get().setStreet(_person.getStreet());
        findbyId(id).get().setComplement(_person.getComplement());
        findbyId(id).get().setRg(_person.getRg());
        findbyId(id).get().setUf(_person.getUf());
        findbyId(id).get().setDistrict(_person.getDistrict());
        findbyId(id).get().setCounty(_person.getCounty());
        findbyId(id).get().setCpf(_person.getCpf());

        return _person;
    }
}


