package br.com.springboot.UserAPi.repository;

import br.com.springboot.UserAPi.dbInMemory.DbList;
import br.com.springboot.UserAPi.model.Person;
import br.com.springboot.UserAPi.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class personRepository {
    private static List<Person> tempList;
    private static Integer id = 1;

    public static class AddLists {


        private static Boolean checkCpf(String cpf){

            for(int i = 0; i < tempList.size(); i++){

                if(Objects.equals(tempList.get(i).getCpf(), cpf)){
                    return Boolean.TRUE;

                }

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


        public static Person findByName(String name) {

            Person  _person =  new Person();

            for(int i = 0; i < tempList.size(); i++){

                if(tempList.get(i).getName().equalsIgnoreCase(name)){

                    _person.setName(tempList.get(i).getName());
                    _person.setId(tempList.get(i).getId());
                    _person.setNumberHome(tempList.get(i).getNumberHome());
                    _person.setComplement(tempList.get(i).getComplement());
                    _person.setDistrict(tempList.get(i).getDistrict());
                    _person.setCpf(tempList.get(i).getCpf());
                    _person.setCounty(tempList.get(i).getCounty());
                    _person.setUf(tempList.get(i).getUf());
                    _person.setStreet(tempList.get(i).getStreet());
                    _person.setRg(tempList.get(i).getRg());

                    return _person;
                }

            }

            return _person;
        }

        public static Person findByCpf(String cpf) {

            Person  _person =  new Person();

            for(int i = 0; i < tempList.size(); i++){

                if(tempList.get(i).getCpf().equalsIgnoreCase(cpf)){

                    _person.setId(tempList.get(i).getId());
                    _person.setNumberHome(tempList.get(i).getNumberHome());
                    _person.setComplement(tempList.get(i).getComplement());
                    _person.setDistrict(tempList.get(i).getDistrict());
                    _person.setCpf(tempList.get(i).getCpf());
                    _person.setCounty(tempList.get(i).getCounty());
                    _person.setUf(tempList.get(i).getUf());
                    _person.setStreet(tempList.get(i).getStreet());
                    _person.setRg(tempList.get(i).getRg());

                    return _person;
                }

            }

            return _person;
        }

    }
}


