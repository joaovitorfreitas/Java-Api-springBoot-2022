package br.com.springboot.UserAPi.dbInMemory;

import br.com.springboot.UserAPi.model.Person;
import br.com.springboot.UserAPi.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class DbList {

    @Getter
    @Setter
    public static class AllLists
    {
        public static List<Person> person;

        public static Long id = 0L;

        public static void ListPerson(Person _person){

            try{

                _person.setId(id++);

                person.add(_person);
            }

            catch (NullPointerException e){

                _person.setId(id++);

                person = new ArrayList<>();

                person.add(_person);
            }
        }
    }
}


