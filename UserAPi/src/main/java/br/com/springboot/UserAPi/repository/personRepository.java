package br.com.springboot.UserAPi.repository;

import br.com.springboot.UserAPi.dbInMemory.DbList;
import br.com.springboot.UserAPi.model.Person;
import br.com.springboot.UserAPi.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class personRepository {
    private static List<Person> tempList;

    public static class AddLists {

//        public static Boolean checkCpf(String cpf){
//
//           Optional<Person> personCpf =  DbList.AllLists.person.stream().filter(person -> person.getCpf() == cpf).findFirst();
//
//           return personCpf.isPresent();
//        }

        public static void AddListPerson(Person _person) {

            if (DbList.getDbList().getPersonList() == null && tempList == null) {

                tempList = new ArrayList<>();

                DbList.getDbList().setPersonList(new ArrayList<>());
            }

            tempList.add(_person);

            DbList.getDbList().setPersonList(tempList);
        }

    }
}


