package br.com.springboot.UserAPi.repository;

import br.com.springboot.UserAPi.dbInMemory.DbList;
import br.com.springboot.UserAPi.model.Person;
import br.com.springboot.UserAPi.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class personRepository {
    private static List<Person> tempList;
    private static Integer id = 1;

    public static class AddLists {


        private static Boolean checkCpf(String cpf){

            for(int i = 0; i < tempList.size(); i++){
                    return tempList.get(i).getCpf().contains(cpf);
                }
            return Boolean.FALSE;
        }

        public static void AddListPerson(Person _person) {

            if (DbList.getDbList().getPersonList() == null && tempList == null) {

                tempList = new ArrayList<>();

                DbList.getDbList().setPersonList(new ArrayList<>());
            }

            if(checkCpf(_person.getCpf())){

                System.out.println("Já tem");
            }else{

                System.out.println("Não tem");


                _person.setId(id ++);

                tempList.add(_person);

                DbList.getDbList().setPersonList(tempList);
            }
        }

        public static boolean RemoveList(Integer idFind){

            for(int i = 0; i < tempList.size(); i++){

                if(tempList.get(i).getId() == idFind){

                    tempList.removeIf(person -> person.getId() == idFind);

                    DbList.getDbList().setPersonList(tempList);

                    return Boolean.TRUE;
                }
            }

            return Boolean.FALSE;
        }
    }
}


