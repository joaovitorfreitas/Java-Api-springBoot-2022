package br.com.springboot.UserAPi.repository;

import br.com.springboot.UserAPi.dbInMemory.DbList;
import br.com.springboot.UserAPi.model.Person;
import br.com.springboot.UserAPi.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class personRepository {
    private static List<Person> tempList;
    private static Integer id = 1;

    public static class AddLists {


        private static Boolean checkCpf(String cpf) {

            for (int i = 0; i < tempList.size(); i++) {

                if (tempList.get(i).getCpf().equals(cpf)) {
                    return Boolean.TRUE;
                }
            }

            return Boolean.FALSE;
        }

        public static Person AddListPerson(Person _person) {

            if (DbList.getDbList().getPersonList() == null && tempList == null) {

                tempList = new ArrayList<>();

                DbList.getDbList().setPersonList(new ArrayList<>());
            }

            if (checkCpf(_person.getCpf())) {

                System.out.println("Já tem");

                return  null;
            }

                _person.setId(id++);

                tempList.add(_person);

                DbList.getDbList().setPersonList(tempList);

                return _person;

        }

        public static boolean RemoveList(Integer idFind) {

            for (int i = 0; i < tempList.size(); i++) {

                if (tempList.get(i).getId() == idFind) {

                    tempList.removeIf(person -> person.getId() == idFind);

                    return Boolean.TRUE;
                }
            }

            return Boolean.FALSE;
        }


        public static Stream<Person> findByName(String name) {

            if(tempList.stream().filter(person -> person.getName().equalsIgnoreCase(name)).count() == 1){
                return tempList.stream().filter(person -> person.getName().equalsIgnoreCase(name));
            }

            return null;
        }


        public static Stream<Person> findByCpf(String cpf) {

            if(tempList.stream().filter(person -> person.getCpf().contains(cpf)).count() == 1){
                return tempList.stream().filter(person -> person.getCpf().contains(cpf));
            }

            return null;
        }

        public static Optional<Person> findbyId(int id) {

           return tempList.stream().filter(person -> person.getId() == id).findFirst();

        }

        public static Person updatePerson(Person _person, int id) {

            if(findbyId(id) == null){
                return null;
            }

            if(_person.getId() == null){
                _person.setId(findbyId(id).get().getId());
            }

            else if(findbyId(id).get().getId() != _person.getId()){
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
}


