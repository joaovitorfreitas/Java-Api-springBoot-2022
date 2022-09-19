package br.com.springboot.UserAPi.dbInMemory;

import br.com.springboot.UserAPi.model.Person;
import br.com.springboot.UserAPi.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class DbList {

    private  List<Person> personList;
    private static DbList dataList;

    public static DbList getDbList(){
        if(dataList == null){
            dataList = new DbList();
        }
        return dataList;
    }
}


